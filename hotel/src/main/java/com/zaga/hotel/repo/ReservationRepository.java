package com.zaga.hotel.repo;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.LockModeType;
import javax.persistence.Query;

import com.zaga.hotel.entity.Reservation;
import com.zaga.hotel.entity.Room;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class ReservationRepository implements PanacheRepositoryBase<Reservation, Long> {

    public Reservation createReservation(Reservation reservation) {

        persistAndFlush(reservation);
        return reservation;
    }

    public Reservation findByReservationId(Long reservationId) {
        return find("reservationId", reservationId).firstResult();
    }

    public List<Reservation> findByRoomNumber(Integer roomNumber) {
        return list("roomNumber", roomNumber);
    }

    public Reservation findRoomBookingByRoomNumberAndDates(String roomNumber, LocalDate checkin, LocalDate checkout) {
        String qlString = "SELECT rb FROM RoomBooking rb WHERE rb.room.roomNumber = :roomNumber AND rb.checkin <= :checkout AND rb.checkout >= :checkin";
        Query query = getEntityManager().createQuery(qlString);
        query.setParameter("roomNumber", roomNumber);
        query.setParameter("checkin", checkin);
        query.setParameter("checkout", checkout);
        return (Reservation) query.getSingleResult();
    }
}
