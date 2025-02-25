package com.lhind.internship.jpaintro.model.entity;

import com.lhind.internship.jpaintro.model.enums.BookingStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bookingdate", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date bookingDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus bookingStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingEndDate=" + bookingDate +
                ", bookingStatus=" + bookingStatus +
                '}';
    }
}
