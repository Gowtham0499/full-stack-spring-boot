package com.clinicals.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicals.app.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
