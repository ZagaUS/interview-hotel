package com.zaga.hotel.serviceimpl;

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

// @Override
// public void updateGuestIdProofPdf(String id, byte[] pdfData) throws Exception
// {
// Guest guest = guestRepo.findById(id);
// if (guest == null) {
// throw new NotFoundException("Guest not found with id " + id);
// }

// guest.setIdProof(pdfData);
// guestRepo.persist(guest);
// }

// @Override
// public void uploadGuestDocument(InputStream inputStream, String guestId) {
// Guest findGuest = guestRepo.findById(guestId);
// findGuest.setIdProof(Binary(inputStream.readAllBytes()));
// //Binary(inputStream.readAllBytes());

// guestRepo.update(guestId, null)
// }
