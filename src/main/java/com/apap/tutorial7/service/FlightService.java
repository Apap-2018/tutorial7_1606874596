package com.apap.tutorial7.service;

import com.apap.tutorial7.model.FlightModel;

import java.util.List;
import java.util.Optional;

/**
 * FlightService
 */
public interface FlightService {
    FlightModel addFlight(FlightModel flight);

    void deleteByFlightNumber(String flightNumber);

    Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber);

    Optional<FlightModel> getFlightDetailByFlightId(long flightId);

    void updateFlight(long flightId, FlightModel flight);

    void deleteFlight(FlightModel flight);

    List<FlightModel> getFlights();


}