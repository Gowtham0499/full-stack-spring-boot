package com.flight.reservation.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${com.flight.reservation.itenarary.dirpath}")
	private String ITENARARY_DIR;

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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookFlight()");
		
		//Payment Logic
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("Saving the Passenger: " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setCheckedIn(false);
		reservation.setPassenger(savedPassenger);
		LOGGER.info("Saving the reservation: " + reservation);
		Reservation reservedTicket = reservationRepository.save(reservation);
		
		String filePath = ITENARARY_DIR + reservedTicket.getId() + ".pdf";
		LOGGER.info("Generating the Itenarary");
		pdfGenerator.generateItinerary(reservedTicket, filePath);
		LOGGER.info("Emailing the Itenarary");
		emailUtil.sendItinerary(reservedTicket.getPassenger().getEmail(), filePath);

		return reservedTicket;
	}

}
