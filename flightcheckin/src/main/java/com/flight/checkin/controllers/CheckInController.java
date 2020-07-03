package com.flight.checkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.checkin.dto.Reservation;
import com.flight.checkin.dto.ReservationUpdateRequest;
import com.flight.checkin.integration.ReservationRestClient;

@Controller
public class CheckInController {
	
	@Autowired
	ReservationRestClient reservationRestClient;

	@RequestMapping(value = "/showStartCheckIn", method = RequestMethod.GET)
	public String showStartCheckIn() {
		return "showStartCheckIn";
	}
	
	@RequestMapping(value = "/startCheckIn", method = RequestMethod.POST)
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap model) {
		Reservation reservation = reservationRestClient.findReservation(reservationId);
		model.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping(value = "/completeCheckIn", method = RequestMethod.POST)
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId, @RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest request = new ReservationUpdateRequest();
		request.setId(reservationId);
		request.setNumberOfBags(numberOfBags);
		request.setCheckedIn(true);
		reservationRestClient.updateReservation(request);
		return "checkInConfirmation";
	}
	
}
