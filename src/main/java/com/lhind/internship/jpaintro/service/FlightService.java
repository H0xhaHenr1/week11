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

    public List<Flight> getFlightsByDateAndAirport(String date, String airport) {
        return flightRepository.findAllFlightsByDateAndAirline(date, airport);
    }

    public Flight createOrUpdateFlight(Long flightId, Flight flight) {
        if (flightId != null) {
            Flight existingFlight = flightRepository.findById(flightId)
                    .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + flightId));

            existingFlight.setFlightNumber(flight.getFlightNumber());
            existingFlight.setFlightNumber(flight.getFlightNumber());
            existingFlight.setAirline(flight.getAirline());
            existingFlight.setDeparture_Date(flight.getDeparture_Date());
            existingFlight.setArrival_Date(flight.getArrival_Date());

            return flightRepository.save(existingFlight);
        } else {
            return flightRepository.save(flight);
        }
    }

}
