package com.zaga.hotel.resource;

import javax.inject.Inject;
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
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.zaga.hotel.entity.Hotel;
import com.zaga.hotel.service.HotelService;

import io.vertx.core.cli.annotations.Description;

@Path("/hotel/info")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Hotel info")
@Description("Hotel info api")
public class HotelResource {

    @Inject
    HotelService hotelService;

    @GET
    @Path("/{hotelId}")
    public Response getHotelById(@PathParam("hotelId") Long hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        if (hotel != null) {
            return Response.ok(hotel).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return Response.status(Response.Status.CREATED).entity(createdHotel).build();
    }

    @PUT
    @Path("/{hotelId}")
    public Response updateHotel(@PathParam("hotelId") Long hotelId, @RequestBody Hotel hotel) {
        Hotel updatedHotel = hotelService.updateHotel(hotelId, hotel);
        if (updatedHotel != null) {
            return Response.ok(updatedHotel).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{hotelId}")
    public Response deleteHotel(@PathParam("hotelId") Long hotelId) {
        boolean deleted = hotelService.deleteHotel(hotelId);
        if (deleted) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
