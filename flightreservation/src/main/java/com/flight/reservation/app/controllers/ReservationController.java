package com.flight.reservation.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.reservation.app.dto.ReservationRequest;
import com.flight.reservation.app.entities.Flight;
import com.flight.reservation.app.entities.Reservation;
import com.flight.reservation.app.repository.FlightRepository;
import com.flight.reservation.app.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
		
	@RequestMapping(value = "/showCompleteReservation", method = RequestMethod.GET)
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap model) {
		Flight flight = flightRepository.findById(flightId).get();
		model.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap model) {
		Reservation reservation = reservationService.bookFlight(request);
		model.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());
		return "reservationConfirmation";
	}

}
