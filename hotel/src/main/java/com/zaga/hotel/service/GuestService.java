package com.zaga.hotel.service;

import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import com.zaga.hotel.entity.Guest;

public interface GuestService {

    Guest createGuest(Guest guest);

    List<Guest> findAllGuests();

    Guest findGuestById(String guestId);

    Guest updateGuest(String guestId, @Valid Guest guest);

    void deleteGuest(String guestId);

    // void updateGuestIdProofPdf(String id, byte[] pdfData) throws Exception;

    // void uploadGuestDocument(InputStream inputStream, String guestId);

}
