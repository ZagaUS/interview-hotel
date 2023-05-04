package com.zaga.hotel.serviceimpl;

import java.io.InputStream;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.zaga.hotel.entity.Guest;
import com.zaga.hotel.repo.GuestRepo;
import com.zaga.hotel.service.GuestService;

@ApplicationScoped
public class GuestServiceImpl implements GuestService {

    @Inject
    GuestRepo guestRepo;

    @Override
    public Guest createGuest(Guest guest) {
        guestRepo.persist(guest);
        return guest;
    }

    @Override
    public List<Guest> findAllGuests() {
        return Guest.listAll();
    }

    @Override
    public Guest findGuestById(String guestId) {
        return guestRepo.findById(guestId);
    }

    @Override
    @Transactional
    public Guest updateGuest(String guestId, @Valid Guest guest) {
        Guest guestToUpdate = Guest.findById(guestId);
        guestToUpdate.setName(guest.getName());
        guestToUpdate.setEmail(guest.getEmail());
        guestToUpdate.setAddress(guest.getAddress());
        guestToUpdate.setBillingInfo(guest.getBillingInfo());
        guestToUpdate.setPhone(guest.getPhone());
        return guestToUpdate;
    }

    @Override
    @Transactional
    public void deleteGuest(String guestId) {
        Guest.deleteById(guestId);
    }

}