package com.flight.checkin.app.integration;

import com.flight.checkin.app.dto.Reservation;
import com.flight.checkin.app.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
