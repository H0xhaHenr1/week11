package com.lhind.internship.jpaintro.repository;

import com.lhind.internship.jpaintro.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM flights f WHERE f.date = :date AND f.airline = :airline")
    List<Flight> findAllFlightsByDateAndAirline(@Param("date") String date,@Param("airline") String airline);
}
