package org.openprocurement.api;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openprocurement.api.model.Tender;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.ws.rs.NotFoundException;

import static org.junit.Assert.assertNotNull;
import static org.openprocurement.api.OpenprocurementClient.SANDBOX_LATEST_URL;
import static org.openprocurement.api.OpenprocurementClient.newProxyClient;

public class OpenprocurementService_SandboxTest {
    final static Logger logger = Logger.getLogger(OpenprocurementService_SandboxTest.class);

    private OpenprocurementService sandboxClient;

    @Before
    public void jerseyLogger() throws Exception {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @Before
    public void setUp() throws Exception {
        sandboxClient = newProxyClient(SANDBOX_LATEST_URL);
    }

    @Test
    public void testGetSingleAution() throws Exception {
        final Tender data = sandboxClient.getTender("34c8236d4df4448dbf849c285f6bbf7a");
        assertNotNull(data);
        logger.debug(String.format("Found trade --> %s", data));
    }

    @Test(expected = NotFoundException.class)
    public void testGetSingleAution_NotFound() throws Exception {
        final Tender notFound = sandboxClient.getTender("unknown_id");
    }
}