package org.openprocurement.api;

import org.joda.time.DateTime;
import org.junit.Test;
import org.mockito.Mockito;
import org.openprocurement.api.model.TenderShortData;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TenderServiceTest {

    @Test
    public void testIsFetchUntilReached() throws Exception {
        final List<TenderShortData> ids = new ArrayList<>();
        ids.add(new TenderShortData("id1", DateTime.now().minusDays(2)));
        ids.add(new TenderShortData("id2", DateTime.now().minusDays(3)));
        ids.add(new TenderShortData("id3", DateTime.now().minusDays(4)));

        // desc
        final TenderService service = new TenderService(Mockito.mock(OpenprocurementApi.class));
        assertTrue(service.isFetchUntilReached(ids, DateTime.now().minusDays(1), true));
        assertTrue(service.isFetchUntilReached(ids, DateTime.now().minusDays(3), true));
        assertFalse(service.isFetchUntilReached(ids, DateTime.now().minusDays(5), true));

        // asc
        ids.clear();
        ids.add(new TenderShortData("id1", DateTime.now().minusDays(4)));
        ids.add(new TenderShortData("id2", DateTime.now().minusDays(3)));
        ids.add(new TenderShortData("id3", DateTime.now().minusDays(2)));

        assertTrue(service.isFetchUntilReached(ids, DateTime.now().minusDays(4), false));
        assertTrue(service.isFetchUntilReached(ids, DateTime.now().minusDays(3), false));
        assertFalse(service.isFetchUntilReached(ids, DateTime.now().minusDays(1), false));

    }
}