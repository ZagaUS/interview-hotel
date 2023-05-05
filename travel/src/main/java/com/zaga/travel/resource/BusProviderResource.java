package com.zaga.travel.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import com.zaga.travel.entity.BusTransportationProvider;
import com.zaga.travel.service.BusProviderService;

@Path("/providers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BusProviderResource {

    @Inject
    BusProviderService providerService;

    @GET
    public List<BusTransportationProvider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GET
    @Path("/{travelId}")
    public BusTransportationProvider getProviderById(@PathParam("travelId") Long travelId) {
        return providerService.getProviderById(travelId);
    }

    @POST
    @Transactional
    public Response createProvider(@RequestBody BusTransportationProvider provider) {
        providerService.createProvider(provider);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{travelId}")
    @Transactional
    public Response updateProvider(@PathParam("travelId") Long travelId,
            @RequestBody BusTransportationProvider provider) {
        providerService.updateProvider(travelId, provider);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{travelId}")
    @Transactional
    public Response deleteProvider(@PathParam("travelId") Long travelId) {
        providerService.deleteProvider(travelId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
