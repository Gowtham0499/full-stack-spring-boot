package com.flight.reservation.app.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.reservation.app.entities.Flight;
import com.flight.reservation.app.repository.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@RequestMapping(value = "findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap model) {
		LOGGER.info("Inside findFlights() method" + " " + "From: " + from + " " + "To: " + to + " " + "Departure Date: " + departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		model.addAttribute("flights", flights);
		return "displayFlights";
	}
	
	@RequestMapping(value = "/admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}

}
