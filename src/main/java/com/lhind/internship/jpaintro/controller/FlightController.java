package com.lhind.internship.jpaintro.controller;

import com.lhind.internship.jpaintro.model.entity.Flight;
import com.lhind.internship.jpaintro.repository.FlightRepository;
import com.lhind.internship.jpaintro.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(FlightController.FLIGHT_URL)
public class FlightController {
    static final String FLIGHT_URL = "/flight";

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping()
    public ResponseEntity<List<Flight>> getAllFlights(){
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        return ResponseEntity.ok(flightService.getFLightById(id).orElse(null));
    }

    @GetMapping("/{date}/{airport}")
    public ResponseEntity<List<Flight>> getFlightsByDateAndAirport(@PathVariable String date, @PathVariable String airport){
        List<Flight> flights = flightService.getFlightsByDateAndAirport(date, airport);
        if(flights.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flights);
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.createOrUpdateFlight(null, flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> updateFlight(
            @PathVariable Long flightId,
            @RequestBody Flight flight) {
        Flight updatedFlight = flightService.createOrUpdateFlight(flightId, flight);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id){
        flightService.deleteById(id);
        return ResponseEntity.ok().build();
    }





}
