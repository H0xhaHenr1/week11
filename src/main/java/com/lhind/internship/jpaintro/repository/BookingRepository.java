package com.lhind.internship.jpaintro.repository;

import com.lhind.internship.jpaintro.model.entity.Booking;
import com.lhind.internship.jpaintro.model.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.awt.print.Book;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long>, JpaSpecificationExecutor<Booking> {
//    List<Booking> findByStatus(BookingStatus status);

}

