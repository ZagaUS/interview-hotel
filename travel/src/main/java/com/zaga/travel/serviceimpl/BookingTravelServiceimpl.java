package com.zaga.travel.serviceimpl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import com.zaga.travel.entity.BookingTravel;
import com.zaga.travel.repo.BookingTravelRepo;
import com.zaga.travel.service.BookingTravelService;

@ApplicationScoped
public class BookingTravelServiceimpl implements BookingTravelService {

    @Inject
    BookingTravelRepo bookingTravelRepository;

    @Override
    public List<BookingTravel> getAllBookingTravels() {
        return bookingTravelRepository.listAll();
    }

    @Override
    public BookingTravel getBookingTravelById(Long bookingId) {
        return bookingTravelRepository.findById(bookingId);
    }

    @Override
    @Transactional
    public BookingTravel createBookingTravel(BookingTravel bookingTravel) {
        bookingTravelRepository.persist(bookingTravel);
        return bookingTravel;
    }

    @Override
    @Transactional
    public BookingTravel updateBookingTravel(Long bookingId, BookingTravel bookingTravel) {
        BookingTravel existingBookingTravel = bookingTravelRepository.findById(bookingId);
        if (existingBookingTravel == null) {
            throw new NotFoundException("BookingTravel with id " + bookingId + " not found");
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
    public void deleteBookingTravel(Long bookingId) {
        BookingTravel bookingTravel = bookingTravelRepository.findById(bookingId);
        if (bookingTravel != null) {
            bookingTravelRepository.delete(bookingTravel);
        }
    }
}