package com.lhind.internship.jpaintro.service;

import com.lhind.internship.jpaintro.model.entity.Booking;
import com.lhind.internship.jpaintro.model.entity.Flight;
import com.lhind.internship.jpaintro.model.entity.User;
import com.lhind.internship.jpaintro.repository.BookingRepository;
import com.lhind.internship.jpaintro.repository.FlightRepository;
import com.lhind.internship.jpaintro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FlightRepository flightRepository;




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

    public List<Booking> getBookingOrderByDescending(){
        return bookingRepository.findAllBookingsOrderByBookingdate();
    }

    public Optional<Booking> getBookingByUserId(Long bookingId,Long userId){
        return bookingRepository.findBookingByIdAndUserId(bookingId, userId);
    }

    public List<Booking> getAllBookingsByUserId(Long userId){
        return bookingRepository.findAllBookingsByUserId(userId);
    }

    public List<Booking> getAllBookingsByFlightId(Long flightId){
        return bookingRepository.findAllBookingsByFlightId(flightId);
    }

    public Booking createOrUpdateBooking(Long bookingId, Booking booking, Long userId, Long flightId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + flightId));

        booking.setUser(user);
        booking.setFlight(flight);

        if (bookingId != null) {
            Booking existingBooking = bookingRepository.findById(bookingId)
                    .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

            existingBooking.setBookingDate(booking.getBookingDate());
            existingBooking.setBookingStatus(booking.getBookingStatus());
            existingBooking.setUser(user);
            existingBooking.setFlight(flight);

            return bookingRepository.save(existingBooking);
        } else {
            return bookingRepository.save(booking);
        }
    }
}
