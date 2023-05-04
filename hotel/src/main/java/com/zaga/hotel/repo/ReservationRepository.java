package com.zaga.hotel.repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.zaga.hotel.entity.Reservation;

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
}
