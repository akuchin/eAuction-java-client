package org.openprocurement.api;

import org.joda.time.DateTime;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface OpenprocurementApi {

    String DESCENDING_PARAM = "1";
    String OPT_PRETTY_PARAM = "1";
    String FEED_CHANGES_PARAM = "changes";

    @GET
    @Path("/auctions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Tender getTender(@PathParam("id") String id);

    @GET
    @Path("/auctions")
    @Produces(MediaType.APPLICATION_JSON)
    TenderList getTendersPage(@QueryParam("offset") DateTime offset,
                              @QueryParam("descending") String descending,
                              @QueryParam("opt_pretty") String opt_pretty
                              );

    @GET
    @Path("/auctions")
    @Produces(MediaType.APPLICATION_JSON)
    TenderList getTendersPage(@QueryParam("offset") String offsetStr,
                              @QueryParam("descending") String descending,
                              @QueryParam("feed") String feed,
                              @QueryParam("opt_pretty") String opt_pretty
                              );
}
