package com.zaga.hotel.resource;

import java.time.LocalDate;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.zaga.hotel.entity.Reservation;
import com.zaga.hotel.entity.Room;
import com.zaga.hotel.service.ReservationService;

@Path("/reservations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Hotel room reservation")
public class ReservationResource {

    @Inject
    ReservationService reservationService;

    @GET
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GET
    @Path("/{reservationId}")
    public Response getReservationById(@PathParam("reservationId") Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        if (reservation != null) {
            return Response.ok(reservation).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/rooms/{roomNumber}")
    public List<Reservation> getReservationsByRoomNumber(@PathParam("roomNumber") Integer roomNumber) {
        return reservationService.getReservationsByRoomNumber(roomNumber);
    }

    @POST
    @Transactional
    @Operation(summary = "Create a new reservation")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Reservation created successfully"),
            @APIResponse(responseCode = "400", description = "Invalid request body"),
            @APIResponse(responseCode = "500", description = "Internal server error")
    })
    public Response createReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{reservationId}")
    @Operation(summary = "update a new reservation")
    @Transactional
    public Response updateReservation(@PathParam("reservationId") Long reservationId,
            @RequestBody Reservation reservation) {
        boolean updated = reservationService.updateReservation(reservationId, reservation);
        if (updated) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/rooms/{roomNumber}")
    public List<Reservation> updateReservationsByRoomNumber(@PathParam("roomNumber") Integer roomNumber,
            @RequestBody Reservation reservation) {
        return reservationService.updateReservationsByRoomNumber(roomNumber, reservation);
    }

    @DELETE
    @Path("/{reservationId}")
    @Transactional
    public Response deleteReservation(@PathParam("reservationId") Long reservationId) {
        boolean deleted = reservationService.deleteReservation(reservationId);
        if (deleted) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/available/{checkin}/{checkout}")
    public List<Room> findAvailableRooms(@QueryParam("checkin") String checkin,
            @QueryParam("checkout") String checkout) {
        LocalDate checkinDate = LocalDate.parse(checkin);
        LocalDate checkoutDate = LocalDate.parse(checkout);
        return reservationService.findAvailableRooms(checkinDate, checkoutDate);
    }

    @GET
    @Path("/{roomNumber}/available")
    public Reservation isRoomAvailable(@PathParam("roomNumber") String roomNumber,
            @QueryParam("checkin") String checkin,
            @QueryParam("checkout") String checkout) {
        LocalDate checkinDate = LocalDate.parse(checkin);
        LocalDate checkoutDate = LocalDate.parse(checkout);
        return reservationService.isRoomAvailable(roomNumber, checkinDate, checkoutDate);
    }
}
