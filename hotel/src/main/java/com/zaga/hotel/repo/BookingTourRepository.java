package com.zaga.hotel.repo;

import javax.enterprise.context.ApplicationScoped;

import com.zaga.hotel.entity.BookingTour;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class BookingTourRepository implements PanacheRepositoryBase<BookingTour, Long> {
}
