package com.zaga.travel.service;

import java.util.List;

import javax.validation.Valid;

import com.zaga.travel.entity.BookingTravel;

public interface BookingTravelService {

    void deleteBookingTravel(Long bookingId);

    BookingTravel updateBookingTravel(Long bookingId, @Valid BookingTravel bookingTravel);

    BookingTravel createBookingTravel(@Valid BookingTravel bookingTravel);

    BookingTravel getBookingTravelById(Long bookingId);

    List<BookingTravel> getAllBookingTravels();

}
