package com.flight.reservation.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.app.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
