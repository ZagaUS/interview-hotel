package com.zaga.hotel.resource;

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

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.zaga.hotel.entity.Guest;
import com.zaga.hotel.service.GuestService;

@Path("/hotel/membership")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GuestResource {

    @Inject
    GuestService guestService;

    @POST
    @Path("/createGuest")
    @APIResponse(responseCode = "200", description = "Created a new guest  - guest", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(type = SchemaType.OBJECT, implementation = Guest.class)))
    @Tag(name = "Create a new Guest profile -Api")
    @Transactional
    public Response createGuest(@Valid Guest guest) {
        guestService.createGuest(guest);

        return Response.ok(guest).build();
    }

    @GET
    @Path("/listallguest")
    @Tag(name = "List All Guest -Api")
    public List<Guest> getAllGuests() {
        return guestService.findAllGuests();
    }

    @GET
    @Path("/guest/{guestId}")
    @Tag(name = "Find guest by id -Api")
    public Guest getGuestById(@PathParam("guestId") String guestId) {
        return guestService.findGuestById(guestId);
    }

    @PUT
    @Path("/guest/{guestId}")
    @Tag(name = "Update Guest -Api")
    public Guest updateGuest(@PathParam("guestId") String guestId, @Valid Guest guest) {
        return guestService.updateGuest(guestId, guest);
    }

    @DELETE
    @Path("/guest/{guestId}")
    @Tag(name = "Delete Guest -Api")
    public void deleteGuest(@PathParam("guestId") String guestId) {
        guestService.deleteGuest(guestId);
    }

    // @PUT
    // // @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    // @Consumes(MediaType.APPLICATION_JSON)
    // public Response uploadguest(InputStream inputStream, @QueryParam("guestId")
    // String guestId)
    // throws IOException {
    // guestService.uploadGuestDocument(inputStream, guestId);
    // return Response.status(Response.Status.CREATED).build();
    // }
}
