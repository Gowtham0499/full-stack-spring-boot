package com.flight.checkin.app.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.flight.checkin.app.dto.Reservation;
import com.flight.checkin.app.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	@Value("${reservation.rest.url}")
	private String RESERVATION_REST_URL;

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
