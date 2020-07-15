package com.clinicals.app.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicals.app.dto.ClinicalDataRequest;
import com.clinicals.app.entities.ClinicalData;
import com.clinicals.app.entities.Patient;
import com.clinicals.app.repositories.ClinicalDataRepository;
import com.clinicals.app.repositories.PatientRepository;
import com.clinicals.app.utils.BMICalculator;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {
	
	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private ClinicalDataRepository clinicalDataRepository;

	@PostMapping(path = "/clinicals")
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		Patient patient = patientRepository.findById(request.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);
		clinicalData.setMeasuredDateTime(new Timestamp(System.currentTimeMillis()));
		return clinicalDataRepository.save(clinicalData);
	}
	
	@GetMapping(path = "/clinicals/{patientId}/{componentName}")
	public List<ClinicalData> getClinicalData(@PathVariable("patientId") int patientId,@PathVariable("componentName") String componentName){
		if(componentName.equals("bmi")) {
			componentName = "hw";
		}
		List<ClinicalData> clinicalData = clinicalDataRepository.findByPatientIdAndComponentNameOrderByMeasuredDateTime(patientId, componentName);
		ArrayList<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
		for (ClinicalData eachEntry : duplicateClinicalData) {
			BMICalculator.calculateBMI(clinicalData, eachEntry);
		}
		return clinicalData;
	}

}
