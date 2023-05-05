package com.zaga.travel.serviceimpl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;



@ApplicationScoped
public class BookingTravelServiceImpl implements BookingTravelService {


    @Override
    public List<BookingTravel> getAllBookingTravels() {
        return bookingTravelRepository.listAll();
    }

    @Override
    public BookingTravel getBookingTravelById(Long id) {
        return bookingTravelRepository.findById(id);
    }

    @Override
    @Transactional
    public BookingTravel createBookingTravel(@Valid BookingTravel bookingTravel) {
        bookingTravelRepository.persist(bookingTravel);
        return bookingTravel;
    }

    @Override
    @Transactional
    public BookingTravel updateBookingTravel(Long id, @Valid BookingTravel bookingTravel) {
        BookingTravel existingBookingTravel = bookingTravelRepository.findById(id);
        if (existingBookingTravel == null) {
            throw new NotFoundException("BookingTravel with id " + id + " not found");
        }
        existingBookingTravel.setGuestId(bookingTravel.getGuestId());
        existingBookingTravel.setTravelId(bookingTravel.getTravelId());
        existingBookingTravel.setProviderName(bookingTravel.getProviderName());
        existingBookingTravel.setBusType(bookingTravel.getBusType());
        existingBookingTravel.setTravelDate(bookingTravel.getTravelDate());
        existingBookingTravel.setTotalCost(bookingTravel.getTotalCost());
        return existingBookingTravel;
    }

    @Override
    @Transactional
    public void deleteBookingTravel(Long id) {
        BookingTravel bookingTravel = bookingTravelRepository.findById(id);
        if (bookingTravel != null) {
            bookingTravelRepository.delete(bookingTravel);
        }
    }
}