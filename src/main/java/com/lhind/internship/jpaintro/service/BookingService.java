package com.lhind.internship.jpaintro.service;

import com.lhind.internship.jpaintro.model.entity.Booking;
import com.lhind.internship.jpaintro.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBookingById(Long Id) {
        return bookingRepository.findById(Id);
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public void deleteBookingById(Long Id){
        bookingRepository.deleteById(Id);
    }
}
