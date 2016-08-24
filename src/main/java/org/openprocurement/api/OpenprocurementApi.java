package org.openprocurement.api;

import org.joda.time.DateTime;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface OpenprocurementApi {

    public enum Params {
        DESCENDING_PARAM("1"),
        OPT_PRETTY_PARAM("1"),
        FEED_CHANGES_PARAM("changes"),
        MODE_TEST_PARAM("test"),
        MODE_ALL_PARAM("_all_");

        final public String value;
        Params(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return name() + "{" +
                    "value='" + value + '\'' +
                    "} ";
        }
    }

    @GET
    @Path("/auctions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Tender getTender(@PathParam("id") String id);

    @GET
    @Path("/auctions")
    @Produces(MediaType.APPLICATION_JSON)
    TenderList getTendersPage(@QueryParam("offset") DateTime offset,
                              @QueryParam("descending") String descending,
                              @QueryParam("opt_pretty") String opt_pretty,
                              @QueryParam("mode") String mode
                              );

    @GET
    @Path("/auctions")
    @Produces(MediaType.APPLICATION_JSON)
    TenderList getTendersPage(@QueryParam("offset") String offsetStr,
                              @QueryParam("descending") String descending,
                              @QueryParam("feed") String feed,
                              @QueryParam("opt_pretty") String opt_pretty,
                              @QueryParam("mode") String mode
                              );
}
