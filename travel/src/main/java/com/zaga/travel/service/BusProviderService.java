package com.zaga.travel.service;

import java.util.List;

import com.zaga.travel.entity.BusTransportationProvider;

public interface BusProviderService {

    List<BusTransportationProvider> getAllProviders();

    BusTransportationProvider getProviderById(Long travelId);

    BusTransportationProvider createProvider(BusTransportationProvider provider);

    BusTransportationProvider updateProvider(Long travelId, BusTransportationProvider provider);

    void deleteProvider(Long travelId);

}
