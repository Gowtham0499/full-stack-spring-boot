package com.flight.reservation.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.app.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
