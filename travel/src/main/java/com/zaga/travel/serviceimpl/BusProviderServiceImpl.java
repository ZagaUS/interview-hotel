package com.zaga.travel.serviceimpl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.zaga.travel.entity.BusTransportationProvider;
import com.zaga.travel.repo.BusTransportationProviderRepository;
import com.zaga.travel.service.BusProviderService;

@ApplicationScoped
public class BusProviderServiceImpl implements BusProviderService {

    @Inject
    BusTransportationProviderRepository providerRepository;

    public List<BusTransportationProvider> getAllProviders() {
        return providerRepository.listAll();
    }

    public BusTransportationProvider getProviderById(Long id) {
        return providerRepository.findById(id);
    }

    public BusTransportationProvider createProvider(BusTransportationProvider provider) {
        providerRepository.persist(provider);
        return provider;
    }

    public BusTransportationProvider updateProvider(Long id, BusTransportationProvider updatedProvider) {
        BusTransportationProvider provider = providerRepository.findById(id);
        if (provider != null) {
            provider.setProviderName(updatedProvider.getProviderName());
            provider.setProviderAddress(updatedProvider.getProviderAddress());
            provider.setPhoneNumber(updatedProvider.getPhoneNumber());
            provider.setBusType(updatedProvider.getBusType());
            providerRepository.persist(provider);
        }
        return provider;
    }

    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }

}