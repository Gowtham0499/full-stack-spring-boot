package com.flight.reservation.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.reservation.app.dto.ReservationRequest;
import com.flight.reservation.app.entities.Flight;
import com.flight.reservation.app.entities.Passenger;
import com.flight.reservation.app.entities.Reservation;
import com.flight.reservation.app.repository.FlightRepository;
import com.flight.reservation.app.repository.PassengerRepository;
import com.flight.reservation.app.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		//Payment Logic
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setCheckedIn(false);
		reservation.setPassenger(savedPassenger);
		Reservation reservedTicket = reservationRepository.save(reservation);	
		
		return reservedTicket;
	}

}
