package com.flight.reservation.app.services;

import com.flight.reservation.app.dto.ReservationRequest;
import com.flight.reservation.app.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
