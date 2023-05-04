package com.zaga.hotel.repo;

import com.zaga.hotel.entity.Hotel;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HotelRepository implements PanacheRepositoryBase<Hotel, Long> {
}
