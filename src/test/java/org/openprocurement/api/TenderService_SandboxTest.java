package org.openprocurement.api;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderShortData;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.List;

import static org.junit.Assert.*;
import static org.openprocurement.api.OpenprocurementClient.SANDBOX_LATEST_URL;
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
        tenderService = TenderService.newInstance(newApiClient(SANDBOX_LATEST_URL));
    }

    @Test
    public void testGetLatestTendersShortData() throws Exception {
        final List<TenderShortData> latestTendersShortData = tenderService.getLatestTendersShortData(5);
        assertEquals(5, latestTendersShortData.size());
    }

    @Test
    public void testGetLatestTeners() throws Exception {
        final int maxAmount = 200;
        final List<Tender> latestTenders = tenderService.getLatestTenders(maxAmount);
        assertTrue(latestTenders.size() >= 10);
        logger.debug(String.format("Found [%d] trades of [%d]", latestTenders.size(), maxAmount));
    }
}