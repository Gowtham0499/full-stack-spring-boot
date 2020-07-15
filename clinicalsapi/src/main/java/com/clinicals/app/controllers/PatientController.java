package com.clinicals.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicals.app.entities.ClinicalData;
import com.clinicals.app.entities.Patient;
import com.clinicals.app.repositories.PatientRepository;
import com.clinicals.app.utils.BMICalculator;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

	Map<String, String> filters = new HashMap<>();

	@Autowired
	private PatientRepository patientRepository;

	@GetMapping(path = "/patients")
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@GetMapping(path = "/patients/{id}")
	public Patient getPatientById(@PathVariable("id") int id) {
		return patientRepository.findById(id).get();
	}

	@PostMapping(path = "/patients")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	@GetMapping(path = "/patients/analyze/{id}")
	public Patient analyze(@PathVariable("id") int id) {
		Patient patient = patientRepository.findById(id).get();
		List<ClinicalData> clinicalData = patient.getClinicalData();
		ArrayList<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
		for (ClinicalData eachEntry : duplicateClinicalData) {

			if (filters.containsKey(eachEntry.getComponentName())) {
				clinicalData.remove(eachEntry);
				continue;
			} else {
				filters.put(eachEntry.getComponentName(), null);
			}

			BMICalculator.calculateBMI(clinicalData, eachEntry);
		}
		filters.clear();
		return patient;
	}

}
