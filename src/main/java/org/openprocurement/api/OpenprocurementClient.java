package org.openprocurement.api;

import com.fasterxml.jackson.datatype.joda.JodaMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.URI;

public class OpenprocurementClient {

    public static final URI SANDBOX_LATEST_URL = URI.create("https://api-sandbox.ea.openprocurement.org/api/0");

    public static OpenprocurementApi newApiClient(URI rootUri) {
        final Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFeature.class));
        final WebTarget rootTarget = client.target(rootUri);

        // joda support
        final JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(new JodaMapper());
        rootTarget.register(provider);

        return WebResourceFactory.newResource(OpenprocurementApi.class, rootTarget);
    }

}
