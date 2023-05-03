package com.zaga.hotel.repo;

import com.zaga.hotel.entity.ScenicTourProvider;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ScenicTourProviderRepository implements PanacheRepository<ScenicTourProvider> {
}
