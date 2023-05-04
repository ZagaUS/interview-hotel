package com.zaga.hotel.repo;

import com.zaga.hotel.entity.Guest;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GuestRepo implements PanacheRepositoryBase<Guest, String> {

    @Override
    public Guest findById(String guestId) {
        return find("guestId", guestId).firstResult();
    }
}
