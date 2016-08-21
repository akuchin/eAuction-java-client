package org.openprocurement.api;

import com.fasterxml.jackson.datatype.joda.JodaMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.URI;

public class OpenprocurementClient {

    public static final URI SANDBOX_LATEST_URL = URI.create("https://api-sandbox.ea.openprocurement.org/api/0");

    /**
     * Creates a new client-side representation of a OpenprocurementApi.
     * <p/>
     *
     * @param rootUri           resource uri.
     * @param connectionTimeout Connect timeout interval, in milliseconds. A value of zero is equivalent to an interval of infinity.
     * @param socketTimeout     WebTarget pointing to the resource or the parent of the resource.
     * @return Instance of a class implementing the OpenprocurementApi interface.
     */
    public static OpenprocurementApi newApiClient(URI rootUri, long connectionTimeout, long socketTimeout) {
        final Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFeature.class));
        client.property(ClientProperties.CONNECT_TIMEOUT, Long.toString(connectionTimeout));
        client.property(ClientProperties.READ_TIMEOUT, Long.toString(socketTimeout));

        final WebTarget rootTarget = client.target(rootUri);

        // joda support
        final JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(new JodaMapper());
        rootTarget.register(provider);

        return WebResourceFactory.newResource(OpenprocurementApi.class, rootTarget);
    }

}
