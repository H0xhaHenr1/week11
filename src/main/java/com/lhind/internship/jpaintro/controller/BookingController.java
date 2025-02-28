package com.lhind.internship.jpaintro.controller;

import com.lhind.internship.jpaintro.model.entity.Booking;
import com.lhind.internship.jpaintro.repository.BookingRepository;
import com.lhind.internship.jpaintro.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(BookingController.BOOKING_URL)
public class BookingController {
    static final String BOOKING_URL = "/bookings";

    private final BookingService bookingService;
    private final BookingRepository bookingRepository;

    public BookingController(BookingService bookingService, BookingRepository bookingRepository) {
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping()
    public ResponseEntity getBookingsDateOrdered(){
        List<Booking> booking = bookingService.getBookingOrderByDescending();
        if (booking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }


    @GetMapping(path = "/user/{bookingId}/{userId}")
    public ResponseEntity getBookingById(Long bookingId, Long userId){
        Optional<Booking> booking = bookingService.getBookingByUserId(bookingId, userId);
        if (booking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity getBookingsByUserId(Long userId){
        List<Booking> booking = bookingService.getAllBookingsByUserId(userId);
        if (booking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/flights/{flightId}")
    public ResponseEntity<?> getAllBookingsByFlightId(Long flightId) {
        List<Booking> bookings = bookingService.getAllBookingsByFlightId(flightId);

        if (bookings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/users/{userId}/flights/{flightId}")
    public ResponseEntity<Booking> createBooking(@PathVariable Long userId, @PathVariable Long flightId, @RequestBody Booking booking) {
        Booking savedBooking = bookingService.createOrUpdateBooking(null, booking, userId, flightId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }

    @PutMapping("/{bookingId}/users/{userId}/flights/{flightId}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable Long bookingId,
            @PathVariable Long userId,
            @PathVariable Long flightId,
            @RequestBody Booking booking) {
        Booking updatedBooking = bookingService.createOrUpdateBooking(bookingId, booking, userId, flightId);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity deleteBooking(@PathVariable Long bookingId){
        bookingService.deleteBookingById(bookingId);
        return ResponseEntity.ok().build();
    }



}


