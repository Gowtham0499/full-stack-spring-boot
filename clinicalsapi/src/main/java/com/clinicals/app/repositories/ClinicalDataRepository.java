package com.clinicals.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicals.app.entities.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {
	
	List<ClinicalData> findByPatientIdAndComponentNameOrderByMeasuredDateTime(int patientId, String componentName);

}
