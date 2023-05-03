package com.zaga.hotel.repo;

import com.zaga.hotel.entity.Tour;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TourRepository implements PanacheRepository<Tour> {
}
