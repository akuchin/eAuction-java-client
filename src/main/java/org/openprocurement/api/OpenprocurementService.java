package org.openprocurement.api;

import org.joda.time.DateTime;
import org.openprocurement.api.model.Tender;
import org.openprocurement.api.model.TenderList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface OpenprocurementService {

    @GET
    @Path("/auctions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Tender getTender(@PathParam("id") String id);

    @GET
    @Path("/auctions")
    @Produces(MediaType.APPLICATION_JSON)
    TenderList getTenders();

    @GET
    @Path("/auctions")
    @Produces(MediaType.APPLICATION_JSON)
    TenderList getTenders(@QueryParam("offset") DateTime offset);
}
