package com.zaga.hotel.serviceimpl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.zaga.hotel.entity.Hotel;
import com.zaga.hotel.repo.HotelRepository;
import com.zaga.hotel.service.HotelService;

@ApplicationScoped
public class HotelServiceImpl implements HotelService {

    @Inject
    HotelRepository hotelRepository;

    @Override
    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId);
    }

    @Override
    @Transactional
    public Hotel createHotel(Hotel hotel) {
        hotelRepository.persist(hotel);
        return hotel;
    }

    @Override
    public Hotel updateHotel(Long hotelId, Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(hotelId);
        if (existingHotel != null) {
            existingHotel.setName(hotel.getName());
            existingHotel.setAddress(hotel.getAddress());
            existingHotel.setPhoneNumber(hotel.getPhoneNumber());
            existingHotel.setNumRoomsAvailable(hotel.getNumRoomsAvailable());
            existingHotel.setTotalRooms(hotel.getTotalRooms());
            return existingHotel;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId);
        if (hotel != null) {
            hotelRepository.delete(hotel);
            return true;
        } else {
            return false;
        }
    }

}
