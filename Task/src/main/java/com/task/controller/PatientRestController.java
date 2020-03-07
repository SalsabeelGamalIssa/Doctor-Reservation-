package com.task.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.*;
import com.task.service.*;



@RestController
@RequestMapping("/api")
public class PatientRestController {

	private PatientService patientService;
	
	@Autowired
	public PatientRestController(PatientService thePatientService) {
		patientService = thePatientService;
	}
	
		@GetMapping("/patients")
	public List<Patient> findAll() {
		return patientService.findAll();
	}

		
	@GetMapping("/patients/{patientId}")
	public Patient getPatient(@PathVariable int patientId) {
		
		Patient thePatient = patientService.findById(patientId);
		
		if (thePatient == null) {
			throw new RuntimeException("Patient id not found - " + patientId);
		}
		
		return thePatient;
	}
	
		
	@PostMapping("/patients")
	public Patient addPatient(@Valid @RequestBody  Patient thePatient) {
		
		thePatient.setPatientId(0);
		
		patientService.save(thePatient);
		
		return thePatient;
	}
	
	
	@PutMapping("/patients")
	public Patient updatePatient(@RequestBody Patient thePatient) {
		
		patientService.save(thePatient);
		
		return thePatient;
	}
	
	
	@DeleteMapping("/patients/{patientId}")
	public String deletePatient(@PathVariable int PatientId) {
		
		Patient tempPatient = patientService.findById(PatientId);
		
				
		if (tempPatient == null) {
			throw new RuntimeException("Patient id not found - " + PatientId);
		}
		
		patientService.deleteById(PatientId);
		
		return "Deleted Patient id - " + PatientId;
	}
	
}










