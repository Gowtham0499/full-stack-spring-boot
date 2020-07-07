package com.flight.reservation.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.app.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
