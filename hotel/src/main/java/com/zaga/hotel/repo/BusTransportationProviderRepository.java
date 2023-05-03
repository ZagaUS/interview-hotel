package com.zaga.hotel.repo;

import javax.enterprise.context.ApplicationScoped;

import com.zaga.hotel.entity.BusTransportationProvider;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BusTransportationProviderRepository implements PanacheRepository<BusTransportationProvider> {
}
