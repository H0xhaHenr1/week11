package com.lhind.internship.jpaintro.model.entity;

import com.lhind.internship.jpaintro.model.enums.FlightStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "airline", nullable = false)
    private String airline;

    @Column(name = "flight_number", nullable = false)
    private Long flightNumber;

    @Column(name = "departure_date", nullable = false)
    private Date departure_Date;

    @Column(name = "arrival_date", nullable = false)
    private Date arrival_Date;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private FlightStatus status;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDeparture_Date() {
        return departure_Date;
    }

    public void setDeparture_Date(Date departure_Date) {
        this.departure_Date = departure_Date;
    }

    public Date getArrival_Date() {
        return arrival_Date;
    }

    public void setArrival_Date(Date arrival_Date) {
        this.arrival_Date = arrival_Date;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", departure_Date=" + departure_Date +
                ", arrival_Date=" + arrival_Date +
                ", status=" + status +
                '}';
    }
}
