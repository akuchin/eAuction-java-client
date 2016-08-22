package org.openprocurement.api;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderList;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.ws.rs.NotFoundException;

import static org.junit.Assert.assertNotNull;
import static org.openprocurement.api.OpenprocurementClient.SANDBOX_0_LATEST_URL;
import static org.openprocurement.api.OpenprocurementClient.SANDBOX_2_3_URL;
import static org.openprocurement.api.OpenprocurementClient.newApiClient;

public class OpenprocurementApi_SandboxTest {
    final static Logger logger = Logger.getLogger(OpenprocurementApi_SandboxTest.class);

    private OpenprocurementApi sandboxClient;

    @Before
    public void jerseyLogger() throws Exception {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @Before
    public void setUp() throws Exception {
        sandboxClient = newApiClient(SANDBOX_2_3_URL, 3000, 3000);
    }

    @Test
    public void testGetSingleTender() throws Exception {
        final Tender data = sandboxClient.getTender("1aca16c4422a472ead40917ae29f4fab");
        assertNotNull(data);
        logger.debug(String.format("Found trade --> %s", data));
    }

    @Test(expected = NotFoundException.class)
    public void testGetSingleTender_NotFound() throws Exception {
        final Tender notFound = sandboxClient.getTender("unknown_id");
    }

    @Test
    public void testGetTendersPage() throws Exception {
        final TenderList tenders = sandboxClient.getTendersPage(null, OpenprocurementApi.DESCENDING_PARAM, null);
        assertNotNull(tenders);
        assertNotNull(tenders.getData());
        logger.debug(String.format("Found [%d] trades", tenders.getData().size()));
    }

    @Test
    public void testGetTendersPage_Offset() throws Exception {
        final DateTime offset = DateTime.now().minusDays(1);
        final TenderList tenders = sandboxClient.getTendersPage(offset, OpenprocurementApi.DESCENDING_PARAM, null);
        assertNotNull(tenders);
        assertNotNull(tenders.getData());
        logger.debug(String.format("Found [%d] trades with offset [%s]", tenders.getData().size(), offset));
    }

}