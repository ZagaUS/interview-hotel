package com.zaga.hotel.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.LockModeType;

import com.zaga.hotel.entity.Reservation;
import com.zaga.hotel.entity.Room;

public interface ReservationService {

    List<Reservation> getAllReservations();

    Reservation getReservationById(Long id);

    void createReservation(Reservation reservation);

    boolean updateReservation(Long id, Reservation reservation);

    boolean deleteReservation(Long id);

    List<Reservation> getReservationsByRoomNumber(Integer roomNumber);

    List<Reservation> updateReservationsByRoomNumber(Integer roomNumber, Reservation reservation);

    List<Room> findAvailableRooms(LocalDate checkinDate, LocalDate checkoutDate);

    Reservation isRoomAvailable(String roomNumber, LocalDate checkinDate, LocalDate checkoutDate);
}
