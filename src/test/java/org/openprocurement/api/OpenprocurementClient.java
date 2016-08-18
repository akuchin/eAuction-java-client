package org.openprocurement.api;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.URI;

public class OpenprocurementClient {

    public static final URI SANDBOX_LATEST_URL = URI.create("https://api-sandbox.ea.openprocurement.org/api/0");

    public static OpenprocurementService newProxyClient(URI rootUri) {
        final Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFeature.class));
        final WebTarget rootTarget = client.target(rootUri);
        return WebResourceFactory.newResource(OpenprocurementService.class, rootTarget);
    }

}
