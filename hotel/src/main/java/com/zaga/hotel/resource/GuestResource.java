package com.zaga.hotel.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    @Transactional
    public Response createGuest(Guest guest) {
        guestService.createGuest(guest);

        return Response.ok(guest).build();
    }
}
