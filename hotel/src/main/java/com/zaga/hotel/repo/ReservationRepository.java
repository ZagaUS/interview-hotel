package com.zaga.hotel.repo;

import com.zaga.hotel.entity.Reservation;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReservationRepository implements PanacheRepository<Reservation> {
}
