package com.apap.tutorial7.controller;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.service.FlightService;
import com.apap.tutorial7.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * FlightController
 */
@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping(value = "/add")
    public FlightModel addFlightSubmit(@RequestBody FlightModel flight) {
        return flightService.addFlight(flight);
    }

    @GetMapping(value = "/view/{flightNumber}")
    public FlightModel flightView(@PathVariable("flightNumber") String flightNumber) {
        FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber).get();
        return flight;
    }

    @GetMapping(value = "/all")
    public List<FlightModel> flightAll() {
        List<FlightModel> flights = flightService.getFlights();
        return flights;
    }

    @DeleteMapping(value = "/delete")
    public String deleteFlight(@RequestParam("flightId") long flightId) {
        FlightModel flight = flightService.getFlightDetailByFlightId(flightId).get();
        flightService.deleteFlight(flight);
        return "Flight has been deleted";
    }

    @PutMapping(value = "/update/{flightId}")
    public String updateFlightSubmit(@PathVariable("flightId") long flightId,
                                     @RequestParam(value="destination", required=false) String destination,
                                     @RequestParam(value="origin", required=false) String origin,
                                     @RequestParam(value="time", required=false) Date time){
        FlightModel flight = flightService.getFlightDetailByFlightId(flightId).get();
        if(flight.equals(null)) {
            return "Couldn't find your flight";
        }
        if (destination != null) {
            flight.setDestination(destination);
        }
        if (origin != null) {
            flight.setOrigin(origin);
        }
        if (time != null) {
            flight.setTime(time);
        }
        flightService.updateFlight(flightId, flight);
        return "Flight update success";
    }
}
