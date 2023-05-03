package com.zaga.hotel.repo;

import com.zaga.hotel.entity.Guest;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GuestRepo implements PanacheRepository<Guest> {

}
