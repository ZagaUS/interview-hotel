package com.zaga.travel.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
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

import com.zaga.travel.entity.BookingTravel;
import com.zaga.travel.service.BookingTravelService;

@Path("/booking-travels")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingTravelResource {

    @Inject
    BookingTravelService bookingTravelService;

    @GET
    public List<BookingTravel> getAllBookingTravels() {
        return bookingTravelService.getAllBookingTravels();
    }

    @GET
    @Path("/{bookingId}")
    public BookingTravel getBookingTravelById(@PathParam("bookingId") Long bookingId) {
        return bookingTravelService.getBookingTravelById(bookingId);
    }

    @POST
    @Transactional
    public Response createBookingTravel(@RequestBody BookingTravel bookingTravel) {
        BookingTravel createdBookingTravel = bookingTravelService.createBookingTravel(bookingTravel);
        return Response.status(Response.Status.CREATED).entity(createdBookingTravel).build();
    }

    @PUT
    @Path("/{bookingId}")
    @Transactional
    public BookingTravel updateBookingTravel(@PathParam("bookingId") Long bookingId,
            @RequestBody BookingTravel bookingTravel) {
        return bookingTravelService.updateBookingTravel(bookingId, bookingTravel);
    }

    @DELETE
    @Path("/{bookingId}")
    @Transactional
    public Response deleteBookingTravel(@PathParam("bookingId") Long bookingId) {
        bookingTravelService.deleteBookingTravel(bookingId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
