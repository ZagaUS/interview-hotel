package com.zaga.hotel.repo;

import javax.enterprise.context.ApplicationScoped;

import com.zaga.hotel.entity.Booking;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BookingRepository implements PanacheRepository<Booking> {
}
