package com.zaga.travel.repo;

import javax.enterprise.context.ApplicationScoped;

import com.zaga.travel.entity.BookingTravel;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class BookingTravelRepo implements PanacheRepositoryBase<BookingTravel, Long> {
}
