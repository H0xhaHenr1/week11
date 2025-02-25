package com.lhind.internship.jpaintro.service;

import com.lhind.internship.jpaintro.model.entity.Flight;
import com.lhind.internship.jpaintro.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public Flight saveFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public Optional<Flight> getFLightById(Long Id){
        return flightRepository.findById(Id);
    }

    public List<Flight> getAllFlights(){
        return  flightRepository.findAll();
    }

    public void deleteById(Long Id){
        flightRepository.deleteById(Id);
    }
}
