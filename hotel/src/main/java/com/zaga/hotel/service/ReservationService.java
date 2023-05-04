package com.zaga.hotel.service;

import java.util.List;

import com.zaga.hotel.entity.Reservation;

public interface ReservationService {

    List<Reservation> getAllReservations();

    Reservation getReservationById(Long id);

    void createReservation(Reservation reservation);

    boolean updateReservation(Long id, Reservation reservation);

    boolean deleteReservation(Long id);

    List<Reservation> getReservationsByRoomNumber(Integer roomNumber);

    List<Reservation> updateReservationsByRoomNumber(Integer roomNumber, Reservation reservation);
}
