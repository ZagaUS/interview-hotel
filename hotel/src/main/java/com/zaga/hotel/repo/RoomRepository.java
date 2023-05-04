package com.zaga.hotel.repo;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import com.zaga.hotel.entity.Room;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class RoomRepository implements PanacheRepositoryBase<Room, Long> {

    public List<Room> findAvailableRooms(LocalDate checkin, LocalDate checkout) {
        Query query = getEntityManager().createQuery(
                "SELECT r FROM Room r WHERE r NOT IN " +
                        "(SELECT rb.room FROM RoomBooking rb " +
                        "WHERE rb.checkin < :checkout AND rb.checkout > :checkin)");
        query.setParameter("checkin", checkin);
        query.setParameter("checkout", checkout);
        return query.getResultList();
    }
}
