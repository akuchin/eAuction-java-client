package org.openprocurement.api;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderShortData;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.openprocurement.api.OpenprocurementClient.SANDBOX_0_LATEST_URL;
import static org.openprocurement.api.OpenprocurementClient.newApiClient;

public class TenderService_SandboxTest {
    final static Logger logger = Logger.getLogger(OpenprocurementApi_SandboxTest.class);

    private TenderService tenderService;

    @Before
    public void jerseyLogger() throws Exception {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @Before
    public void setUp() throws Exception {
        tenderService = TenderService.newInstance(newApiClient(SANDBOX_0_LATEST_URL, 3000, 3000));
    }

    @Test
    public void testGetLatestTenderIds() throws Exception {
        final List<TenderShortData> latestTendersShortData = tenderService.getLatestTendersIds(null, 5);
        assertEquals(5, latestTendersShortData.size());
    }

    @Test
    public void testGetTenderIds_Offset_ChangingFeed() throws Exception {
        final List<TenderShortData> latestTendersShortData = tenderService.getTendersIds("aad2b219e005d65f0ec5b9967718bc80",
                5, null, true, true, true);
        assertEquals(5, latestTendersShortData.size());
    }

    @Test
    public void testGetLastTenderIds_For2Days() throws Exception {
        final DateTime fetchUntil = DateTime.now().minusDays(1).withTimeAtStartOfDay();
        final List<TenderShortData> ids = tenderService.getTendersIds(null,
                5, fetchUntil, true, true, false);
        assertEquals(5, ids.size());
        logger.debug(String.format("Found [%d] latest trades until [%s]", ids.size(), fetchUntil));
    }

    @Test
    public void testGetLatestTeners() throws Exception {
        final int maxAmount = 20;
        final List<Tender> latestTenders = tenderService.getLatestTenders(maxAmount);
        assertTrue(latestTenders.size() >= 10);
        logger.debug(String.format("Found [%d] trades of [%d]", latestTenders.size(), maxAmount));
    }
}
