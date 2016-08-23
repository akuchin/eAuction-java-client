package org.openprocurement.api;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.joda.time.DateTime;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderList;
import org.openprocurement.api.model.TenderShortData;
import org.slf4j.LoggerFactory;

import static org.openprocurement.api.OpenprocurementApi.Params.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TenderService {
    final static Logger logger = LoggerFactory.getLogger(TenderService.class);

    private final static DateTimeFormatter dateTimeFormat = ISODateTimeFormat.dateTime();

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

    public List<TenderShortData> getLatestTendersIds(DateTime offset, Integer maxAmount) {
        final String offsetStrParam = offset != null ? dateTimeFormat.print(offset) : null;
        return getTendersIds(offsetStrParam, maxAmount, null, OpenprocurementApi.Mode.PROD, DESCENDING_PARAM);
    }
    public List<TenderShortData> getTendersIds(String offsetStr, Integer maxAmount, DateTime fetchUntil,
                                               OpenprocurementApi.Mode mode, OpenprocurementApi.Params ... params) {
        final Long start = DateTime.now().getMillis();

        // params resolver
        final List<OpenprocurementApi.Params> paramsList = Arrays.asList(params);
        final boolean descendingOrder = paramsList.contains(DESCENDING_PARAM);
        final String descendingParam = descendingOrder ? DESCENDING_PARAM.value : null;
        final String feedChangesParam = paramsList.contains(FEED_CHANGES_PARAM) ? FEED_CHANGES_PARAM.value : null;
        final String prettyParam = paramsList.contains(OPT_PRETTY_PARAM) ? OPT_PRETTY_PARAM.value : null;
        final String modeParam = (mode != null) ? mode.value : null;

        logger.debug(String.format("Fetching tender ids with offset [%s] max amount [%d] fetchUntil [%s] " +
                        "mode [%s] parameters [%s]...",
                offsetStr, maxAmount, fetchUntil, mode, params));
        String offsetStrParam = offsetStr;
        final List<TenderShortData> res = new ArrayList<>();
        while (!isMaxAmountReached(maxAmount, res) && !isFetchUntilReached(res, fetchUntil, descendingOrder)) {
            logger.debug(String.format("Fetching tender ids page with offset [%s] mode [%s] parameters [%s] ...",
                    offsetStrParam, mode, params));
            final TenderList tendersPage = api.getTendersPage(offsetStrParam, descendingParam, feedChangesParam, prettyParam, modeParam);
            final List<TenderShortData> fetched = tendersPage.getData() != null ? tendersPage.getData() : Collections.EMPTY_LIST;
            logger.debug(String.format("Fetched [%d] tender ids from the page", fetched.size()));
            res.addAll(fetched);
            if (tendersPage.getNextPage() == null || fetched.isEmpty()) {
                // nothing more to fetch
                break;
            } else {
                // next fetch with offset
                offsetStrParam = tendersPage.getNextPage().getOffset();
            }
        }

        final Long end = DateTime.now().getMillis();
        logger.debug(String.format("Fetched [%d] tender ids of [%d] with offset [%s] descending [%s] feed [%s] pretty [%s] in [%d] millis",
                res.size(), maxAmount, offsetStr, descendingParam, feedChangesParam, prettyParam, end - start));

        // TODO add cutout also by fetch until
        if (maxAmount != null && res.size() > maxAmount) {
            return Collections.unmodifiableList(res.subList(0, maxAmount ));
        } else {
            return Collections.unmodifiableList(res);
        }
    }

    private boolean isMaxAmountReached(Integer maxAmount, List<TenderShortData> res) {
        return maxAmount != null && res.size() >= maxAmount.intValue();
    }

    protected boolean isFetchUntilReached(List<TenderShortData> idsList, DateTime fetchUntil, boolean isDescending) {
        if (!idsList.isEmpty() && fetchUntil != null) {
            final TenderShortData last = idsList.get(idsList.size() - 1);

            if (isDescending) {
                return last.getDateModified().isBefore(fetchUntil);
            } else {
                return last.getDateModified().isAfter(fetchUntil);
            }
        }
        return false;
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
