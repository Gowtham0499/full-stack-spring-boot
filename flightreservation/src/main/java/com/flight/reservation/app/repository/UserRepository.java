package com.flight.reservation.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
