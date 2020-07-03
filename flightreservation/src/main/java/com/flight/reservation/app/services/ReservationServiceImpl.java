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
import com.flight.reservation.app.util.EmailUtil;
import com.flight.reservation.app.util.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PdfGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;

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
		
		String filePath = "F:\\Software\\InstalledSoftwares\\eclipse\\fullstack\\reservations" + reservedTicket.getId() + ".pdf";
		pdfGenerator.generateItinerary(reservedTicket, filePath);
		
		emailUtil.sendItinerary(reservedTicket.getPassenger().getEmail(), filePath);

		return reservedTicket;
	}

}
