package com.zaga.hotel.service;

import com.zaga.hotel.entity.Hotel;

public interface HotelService {

    Hotel getHotelById(Long hotelId);

    Hotel createHotel(Hotel hotel);

    Hotel updateHotel(Long hotelId, Hotel hotel);

    boolean deleteHotel(Long hotelId);

}
