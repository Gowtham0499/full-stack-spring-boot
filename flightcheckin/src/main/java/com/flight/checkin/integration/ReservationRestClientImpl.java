package com.flight.checkin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.flight.checkin.dto.Reservation;
import com.flight.checkin.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate template = new RestTemplate();
		Reservation reservation = template.getForObject(RESERVATION_REST_URL + id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate template = new RestTemplate();
		Reservation reservation = template.postForObject(RESERVATION_REST_URL, request, Reservation.class);
		return reservation;
	}

}
