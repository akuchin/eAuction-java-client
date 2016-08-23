package org.openprocurement.api;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderShortData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.List;

import static org.junit.Assert.*;
import static org.openprocurement.api.OpenprocurementClientFactory.SANDBOX_0_LATEST_URL;
import static org.openprocurement.api.OpenprocurementClientFactory.SANDBOX_2_3_PUBLIC_URL;
import static org.openprocurement.api.OpenprocurementClientFactory.newApiProxyClient;
import static org.openprocurement.api.OpenprocurementApi.Params.*;

public class TenderService_SandboxTest {
    final static Logger logger = LoggerFactory.getLogger(TenderService_SandboxTest.class);

    private TenderService tenderService;

    @BeforeClass
    public static void jerseyLogger() throws Exception {
        java.util.logging.Logger.getLogger("").setLevel(java.util.logging.Level.FINEST);
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @Before
    public void setUp() throws Exception {
        tenderService = TenderService.newInstance(newApiProxyClient(SANDBOX_2_3_PUBLIC_URL, 3000, 3000));
    }

    @Test
    public void testGetLatestTenderIds() throws Exception {
        final List<TenderShortData> latestTendersShortData = tenderService.getLatestTendersIds(null, 2);
        assertEquals(2, latestTendersShortData.size());
    }

    @Test
    public void testGetTenderIds_Offset_ChangingFeed() throws Exception {
        final List<TenderShortData> latestTendersShortData = tenderService.getTendersIds("aad2b219e005d65f0ec5b9967718bc80",
                5, null, OpenprocurementApi.Mode.ALL, OpenprocurementApi.Params.DESCENDING_PARAM);
        assertEquals(5, latestTendersShortData.size());
    }

    @Test
    public void testGetLastTenderIds_For2Days() throws Exception {
        final DateTime fetchUntil = DateTime.now().minusDays(1).withTimeAtStartOfDay();
        final List<TenderShortData> ids = tenderService.getTendersIds(null,
                5, fetchUntil, OpenprocurementApi.Mode.ALL, DESCENDING_PARAM,FEED_CHANGES_PARAM);
        assertEquals(5, ids.size());
        logger.info(String.format("Found [%d] latest trades until [%s]", ids.size(), fetchUntil));
    }

    @Test
    public void testGetLatestTeners() throws Exception {
        final int maxAmount = 20;
        final List<Tender> latestTenders = tenderService.getLatestTenders(maxAmount);
        assertTrue(latestTenders.size() >= 2);
        logger.info(String.format("Found [%d] trades of [%d]", latestTenders.size(), maxAmount));
    }
}
