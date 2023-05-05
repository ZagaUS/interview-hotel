package com.zaga.hotel.resource;

import java.util.List;

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

import com.zaga.hotel.entity.Room;
import com.zaga.hotel.service.RoomService;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    @Inject
    RoomService roomService;

    @GET
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GET
    @Path("/{roomId}")
    public Room getRoomById(@PathParam("roomId") Long roomId) {
        return roomService.getRoomById(roomId);
    }

    @POST
    public Response createRoom(Room room) {
        Room createdRoom = roomService.createRoom(room);
        return Response.status(Response.Status.CREATED).entity(createdRoom).build();
    }

    @PUT
    @Path("/{roomId}")
    public Room updateRoom(@PathParam("roomId") Long roomId, Room room) {
        return roomService.updateRoom(roomId, room);
    }

    @DELETE
    @Path("/{roomId}")
    public Response deleteRoom(@PathParam("roomId") Long roomId) {
        roomService.deleteRoom(roomId);
        return Response.noContent().build();
    }
}
