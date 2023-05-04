package com.zaga.hotel.serviceimpl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.zaga.hotel.entity.Guest;
import com.zaga.hotel.entity.Hotel;
import com.zaga.hotel.entity.Reservation;
import com.zaga.hotel.entity.Room;
import com.zaga.hotel.repo.GuestRepo;
import com.zaga.hotel.repo.HotelRepository;
import com.zaga.hotel.repo.ReservationRepository;
import com.zaga.hotel.service.ReservationService;

@ApplicationScoped
public class ReservationServiceImpl implements ReservationService {

    @Inject
    ReservationRepository reservationRepository;

    @Inject
    GuestRepo guestRepo;

    @Inject
    HotelRepository hotelRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.listAll();
    }

    @Override
    public void createReservation(Reservation reservation) {
        Guest guest = Guest.findById(reservation.guestId.getGuestId());
        Hotel hotel = Hotel.findById(reservation.hotelId.getHotelId());
        Room room = Room.find("roomNumber", reservation.roomNumber).firstResult();

        if (guest == null || hotel == null || room == null) {
            throw new WebApplicationException("Invalid guest, hotel, or room specified", Response.Status.BAD_REQUEST);
        }
        reservationRepository.persist(reservation);
    }

    @Override
    public boolean updateReservation(Long reservationid, Reservation reservation) {
        Reservation updateReservation = reservationRepository.findById(reservationid);
        if (updateReservation != null) {
            updateReservation.guestId = reservation.guestId;
            updateReservation.hotelId = reservation.hotelId;
            updateReservation.roomNumber = reservation.roomNumber;
            updateReservation.checkInDate = reservation.checkInDate;
            updateReservation.checkOutDate = reservation.checkOutDate;
            updateReservation.totalCost = reservation.totalCost;
            updateReservation.persist();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReservation(Long reservationid) {
        Reservation reservation = reservationRepository.findById(reservationid);
        if (reservation != null) {
            reservation.delete();
            return true;
        }
        return false;
    }

    @Override
    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findByReservationId(reservationId);
    }

    @Override
    public List<Reservation> getReservationsByRoomNumber(Integer roomNumber) {
        return reservationRepository.findByRoomNumber(roomNumber);
    }

    @Override
    public List<Reservation> updateReservationsByRoomNumber(Integer roomNumber, Reservation reservation) {
        List<Reservation> reservations = reservationRepository.findByRoomNumber(roomNumber);
        for (Reservation updateReservation : reservations) {
            updateReservation.guestId = reservation.guestId;
            updateReservation.checkInDate = reservation.checkInDate;
            updateReservation.checkOutDate = reservation.checkOutDate;
            updateReservation.roomNumber = reservation.roomNumber;
            updateReservation.reservationId = reservation.reservationId;
            updateReservation.totalCost = reservation.totalCost;
            reservationRepository.persistAndFlush(reservation);
        }
        return reservations;
    }

}