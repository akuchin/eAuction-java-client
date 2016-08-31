package org.openprocurement.api;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import org.apache.http.entity.ContentType;
import org.junit.Rule;
import org.junit.Test;
import org.openprocurement.api.model.TenderData;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.openprocurement.api.OpenprocurementClientFactory.newApiProxyClient;

public class GetTenderPactTest {

    @Rule
    public PactProviderRule mockProvider = new PactProviderRule("openprocurement", "localhost", 7695, this);

    @Pact(consumer="consumer") // will default to the provider name from mockProvider
    public PactFragment createFragment(PactDslWithProvider builder) throws Exception {
        String responseBody = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("org/openprocurement/api/getTender.response.json").toURI())));

        return builder
//                .given("test state")
                .uponReceiving("Get tender by id call")
                .path("/auctions/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(responseBody, ContentType.APPLICATION_JSON)
                .toFragment();
    }

    @Test
    @PactVerification
    public void runTest() {

        TenderService tenderService = TenderService.newInstance(newApiProxyClient(URI.create("http://localhost:7695/"), 3000, 3000));

        TenderData tender = tenderService.getTenderById("1").getData();


        assertEquals("UA-EA-2016-08-29-000077", tender.getAuctionID());
        assertEquals(TenderData.ProcurementMethod.OPEN, tender.getProcurementMethod());
        assertEquals("[ТЕСТУВАННЯ] Universal zero tolerance moderator", tender.getTitle());
        assertEquals(1, tender.getItems().size());
    }
}
