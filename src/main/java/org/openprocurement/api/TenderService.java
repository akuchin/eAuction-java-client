package org.openprocurement.api;

import org.joda.time.DateTime;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderList;
import org.openprocurement.api.model.TenderShortData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TenderService {

    private final OpenprocurementApi api;

    public TenderService(OpenprocurementApi api) {
        this.api = api;
    }

    public static TenderService newInstance(OpenprocurementApi api) {
        return new TenderService(api);
    }

    public Tender getTender(String id) {
        return api.getTender(id);
    }

    public List<TenderShortData> getLatestTendersShortData(Integer maxAmount) {
        DateTime offset = null;
        final List<TenderShortData> res = new ArrayList<>();
        while (maxAmount == null || maxAmount.intValue() > res.size()) {
            final TenderList tendersPage = (offset != null) ? api.getTendersPage(offset) : api.getTendersPage();
            final List<TenderShortData> fetched = tendersPage.getData() != null ? tendersPage.getData() : Collections.EMPTY_LIST;
            res.addAll(fetched);
            if (tendersPage.getNextPage() == null || fetched.isEmpty()) {
                // nothing more to fetch
                break;
            } else {
                // next fetch with offset
                offset = tendersPage.getNextPage().getOffset();
            }
        }

        if (maxAmount != null && res.size() > maxAmount) {
            return Collections.unmodifiableList(res.subList(0, maxAmount -1));
        } else {
            return Collections.unmodifiableList(res);
        }
    }

    public List<Tender> getLatestTenders(Integer maxAmount) {
        final List<TenderShortData> shortDataList = getLatestTendersShortData(maxAmount);
        final List<Tender> tenderList = shortDataList.stream()
                .map(sd -> api.getTender(sd.getId()))
                .collect(Collectors.toList());
        return tenderList;
    }


}
