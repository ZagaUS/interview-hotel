package com.zaga.hotel.repo;

import com.zaga.hotel.entity.Hotel;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HotelRepository implements PanacheRepository<Hotel> {
}
