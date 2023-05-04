package com.zaga.hotel.resource;

import java.io.IOException;
import java.io.InputStream;
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
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.zaga.hotel.entity.FormData;
import com.zaga.hotel.entity.Guest;
import com.zaga.hotel.repo.GuestRepo;
import com.zaga.hotel.service.GuestService;

import io.vertx.core.cli.annotations.Description;

@Path("/hotel/membership")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Guest profile -Api")
public class GuestResource {

    @Inject
    GuestService guestService;

    @Inject
    GuestRepo guestRepo;

    @POST
    @Path("/createGuest")
    @APIResponse(responseCode = "200", description = "Created a new guest  - guest", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(type = SchemaType.OBJECT, implementation = Guest.class)))
    @Description("Create a new Guest profile -Api")
    @Transactional
    public Response createGuest(@Valid Guest guest) {
        guestService.createGuest(guest);

        return Response.ok(guest).build();
    }

    @GET
    @Path("/listallguest")
    @Description("List All Guest -Api")
    public List<Guest> getAllGuests() {
        return guestService.findAllGuests();
    }

    @GET
    @Path("/guest/{guestId}")
    @Description("Find guest by id -Api")
    public Guest getGuestById(@PathParam("guestId") String guestId) {
        return guestService.findGuestById(guestId);
    }

    @PUT
    @Path("/guest/{guestId}")
    @Description("Update Guest -Api")
    public Guest updateGuest(@PathParam("guestId") String guestId, @Valid Guest guest) {
        return guestService.updateGuest(guestId, guest);
    }

    @DELETE
    @Path("/guest/{guestId}")
    @Description("Delete Guest -Api")
    public void deleteGuest(@PathParam("guestId") String guestId) {
        guestService.deleteGuest(guestId);
    }

    @POST
    @Path("/{guestId}/pdf")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    @Description("upload the id proof api")
    public Response updatePDF(@PathParam("guestId") String guestId, @MultipartForm FormData formData) {
        Guest guest = guestRepo.findById(guestId);
        if (guest == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        try (InputStream fileStream = formData.pdfFile) {
            byte[] pdfBytes = fileStream.readAllBytes();
            guest.idProof = pdfBytes;
            guest.persist();
        } catch (IOException e) {
            // Handle the exception as needed
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }
}
