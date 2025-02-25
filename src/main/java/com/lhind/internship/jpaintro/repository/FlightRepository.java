package com.lhind.internship.jpaintro.repository;

import com.lhind.internship.jpaintro.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
