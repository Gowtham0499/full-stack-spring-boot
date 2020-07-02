package com.flight.reservation.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.app.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
