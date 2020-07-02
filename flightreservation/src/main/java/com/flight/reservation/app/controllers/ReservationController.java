package com.flight.reservation.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.reservation.app.entities.Flight;
import com.flight.reservation.app.repository.FlightRepository;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@RequestMapping(value = "/showCompleteReservation", method = RequestMethod.GET)
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap model) {
		Flight flight = flightRepository.findById(flightId).get();
		model.addAttribute("flight", flight);
		return "completeReservation";
	}

}
