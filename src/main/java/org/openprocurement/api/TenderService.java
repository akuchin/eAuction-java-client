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

    public Tender getTenderById(String id) {
        logger.debug(String.format("Fetching tender id=[%s] ...", id));
        return api.getTender(id);
    }

    public List<TenderShortData> getTendersIds(String offsetStr, Integer maxAmount, DateTime fetchUntil,
                                               OpenprocurementApi.Params ... params) {
        final Long start = DateTime.now().getMillis();

        // params resolver
        final List<OpenprocurementApi.Params> paramsList = Arrays.asList(params);
        final boolean descendingOrder = paramsList.contains(DESCENDING_PARAM);
        final String descendingParam = descendingOrder ? DESCENDING_PARAM.value : null;
        final String feedChangesParam = paramsList.contains(FEED_CHANGES_PARAM) ? FEED_CHANGES_PARAM.value : null;
        final String prettyParam = paramsList.contains(OPT_PRETTY_PARAM) ? OPT_PRETTY_PARAM.value : null;
        final String modeParam = paramsList.contains(MODE_ALL_PARAM) ? MODE_ALL_PARAM.value :
                paramsList.contains(MODE_TEST_PARAM) ? MODE_TEST_PARAM.value : null;

        logger.debug(String.format("Fetching tender ids with offset [%s] max amount [%d] fetchUntil [%s] " +
                        "parameters [%s]...",
                offsetStr, maxAmount, fetchUntil, paramsList));
        String offsetStrParam = offsetStr;
        final List<TenderShortData> res = new ArrayList<>();
        while (!isMaxAmountReached(maxAmount, res) && !isFetchUntilReached(res, fetchUntil, descendingOrder)) {
            logger.debug(String.format("Fetching tender ids page with offset [%s] parameters [%s] ...",
                    offsetStrParam, paramsList));
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

        final List<TenderShortData> cutResult = cutout(res, maxAmount, fetchUntil, descendingOrder);

        final Long end = DateTime.now().getMillis();
        logger.debug(String.format("Fetching is done. Found [%d] tender ids. Fetched [%d] ids " +
                        "max amount [%d] fetch until [%s] with offset [%s] descending [%s] " +
                        "feed [%s] pretty [%s] mode [%s] in [%d] millis",
                cutResult.size(), res.size(),
                maxAmount, fetchUntil, offsetStr, descendingParam,
                feedChangesParam, prettyParam, modeParam, end - start));

        return Collections.unmodifiableList(cutResult);
    }

    private List<TenderShortData> cutout(List<TenderShortData> idsList,
                                         Integer maxAmount,
                                         DateTime fetchUntil,
                                         boolean isDescending) {
        List<TenderShortData> res = idsList;
        if (maxAmount != null && idsList.size() > maxAmount) {
            res = idsList.subList(0, maxAmount);
        }
        if (fetchUntil != null) {
            res = res.stream()
                    .filter(id -> !isFetchUntilReached(id, fetchUntil, isDescending))
                    .collect(Collectors.toList());
        }
        return res;
    }

    private boolean isMaxAmountReached(Integer maxAmount, List<TenderShortData> res) {
        return maxAmount != null && res.size() >= maxAmount.intValue();
    }

    protected boolean isFetchUntilReached(List<TenderShortData> idsList, DateTime fetchUntil, boolean isDescending) {
        if (!idsList.isEmpty() && fetchUntil != null) {
            final TenderShortData last = idsList.get(idsList.size() - 1);
            return isFetchUntilReached(last, fetchUntil, isDescending);
        }
        return false;
    }

    protected boolean isFetchUntilReached(TenderShortData id, DateTime fetchUntil, boolean isDescending) {
        if (id != null && fetchUntil != null) {
            if (isDescending) {
                return id.getDateModified().isBefore(fetchUntil);
            } else {
                return id.getDateModified().isAfter(fetchUntil);
            }
        }
        return false;
    }

}
