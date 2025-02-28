package com.lhind.internship.jpaintro.repository;

import com.lhind.internship.jpaintro.model.entity.Booking;
import com.lhind.internship.jpaintro.model.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.ls.LSException;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long>, JpaSpecificationExecutor<Booking> {
    @Query("SELECT b FROm booking b ORDER BY b.bookingDate DESC")
    List<Booking> findAllBookingsOrderByBookingdate();

    @Query("SELECT b FROM booking b WHERE b.id = :bookingId and b.user.id = :userID")
    Optional<Booking> findBookingByIdAndUserId(@Param("bookingId") Long bookingId,@Param("userId") Long userID);

    @Query("SELECT b FROM booking b WHERE b.user.id = :userId")
    List<Booking> findAllBookingsByUserId(@Param("userId") Long userId);

    @Query("SELECT b FROM booking b WHERE b.flight.id = :flightId")
    List<Booking> findAllBookingsByFlightId(@Param("flightId") Long flightId);
}

