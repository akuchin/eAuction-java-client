package org.openprocurement.api;

import org.slf4j.Logger;
import org.joda.time.DateTime;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderList;
import org.openprocurement.api.model.TenderShortData;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TenderService {
    final static Logger logger = LoggerFactory.getLogger(TenderService.class);

    private final OpenprocurementApi api;

    public TenderService(OpenprocurementApi api) {
        this.api = api;
    }

    public static TenderService newInstance(OpenprocurementApi api) {
        return new TenderService(api);
    }

    public Tender getTender(String id) {
        logger.debug(String.format("Fetching tender id=[%s] ...", id));
        return api.getTender(id);
    }

    public List<TenderShortData> getLatestTendersIds(DateTime offsetParam, Integer maxAmount) {
        final Long start = DateTime.now().getMillis();

        logger.debug(String.format("Fetching tender ids with offset [%s] and max amount [%d] ...", offsetParam, maxAmount));
        DateTime offset = offsetParam;
        final List<TenderShortData> res = new ArrayList<>();
        while (maxAmount == null || maxAmount.intValue() > res.size()) {
            logger.debug(String.format("Fetching tender ids page with offset [%s]", offset));
            final TenderList tendersPage = api.getTendersPage(offset, OpenprocurementApi.DESCENDING_PARAM, null); // offset is nullable
            final List<TenderShortData> fetched = tendersPage.getData() != null ? tendersPage.getData() : Collections.EMPTY_LIST;
            logger.debug(String.format("Fetched [%d] tender ids from the page", fetched.size()));
            res.addAll(fetched);
            if (tendersPage.getNextPage() == null || fetched.isEmpty()) {
                // nothing more to fetch
                break;
            } else {
                // next fetch with offset
                offset = tendersPage.getNextPage().getOffset();
            }
        }

        final Long end = DateTime.now().getMillis();
        logger.debug(String.format("Fetched [%d] tender ids of [%d] in [%d] millis",
                res.size(), maxAmount, end - start));

        if (maxAmount != null && res.size() > maxAmount) {
            return Collections.unmodifiableList(res.subList(0, maxAmount ));
        } else {
            return Collections.unmodifiableList(res);
        }
    }

    public List<Tender> getLatestTenders(Integer maxAmount) {
        final Long start = DateTime.now().getMillis();
        logger.debug(String.format("Fetching latest tenders. Max amount [%d] ...", maxAmount));
        final List<TenderShortData> shortDataList = getLatestTendersIds(null, maxAmount);
        final List<Tender> tenderList = shortDataList.stream()
                .map(sd -> getTender(sd.getId()))
                .collect(Collectors.toList());

        final Long end = DateTime.now().getMillis();
        logger.debug(String.format("Fetched [%d] latest tenders of [%d] in [%d] millis",
                tenderList.size(), maxAmount, end - start));

        return tenderList;
    }


}
