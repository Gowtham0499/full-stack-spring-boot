package com.flight.reservation.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.reservation.app.dto.ReservationUpdateRequest;
import com.flight.reservation.app.entities.Reservation;
import com.flight.reservation.app.repository.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRepository.findById(id).get();
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return reservationRepository.save(reservation);
	}

}
