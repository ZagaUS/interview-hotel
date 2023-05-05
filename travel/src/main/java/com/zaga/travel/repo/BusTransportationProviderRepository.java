package com.zaga.travel.repo;

import javax.enterprise.context.ApplicationScoped;

import com.zaga.travel.entity.BusTransportationProvider;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class BusTransportationProviderRepository implements PanacheRepositoryBase<BusTransportationProvider, Long> {
}
