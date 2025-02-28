package com.lhind.internship.jpaintro.model.entity;

import com.lhind.internship.jpaintro.model.enums.BookingStatus;
import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.util.Date;

@Entity
@Table(name = "booking")
public class  Booking {

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
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
