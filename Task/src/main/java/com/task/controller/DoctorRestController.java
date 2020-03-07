package com.task.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
;

@ComponentScan(basePackages ="com.Task.springboot.controller")
@RestController
@RequestMapping("/api")
public class DoctorRestController {

	private DoctorService doctorService;
	
	@Autowired
	public DoctorRestController(DoctorService theDoctorService) {
		doctorService = theDoctorService;
	}
	
		@GetMapping("/doctors")
	public List<Doctor> findAll() {
		return doctorService.findAll();
	}

		
	@GetMapping("/doctors/{doctorId}")
	public Doctor getDoctor(@PathVariable int doctorId) {
		
		Doctor theDoctor = doctorService.findById(doctorId);
		
		if (theDoctor == null) {
			throw new RuntimeException("Doctor id not found - " + doctorId);
		}
		
		return theDoctor;
	}
	
		
	@PostMapping("/doctors")
	public Doctor addDoctor(@Valid @RequestBody Doctor theDoctor) {
		
	
		
		theDoctor.setDrId(0);
		
		doctorService.save(theDoctor);
		
		return theDoctor;
	}
	
	
	@PutMapping("/doctors")
	public Doctor updateDoctor(@RequestBody Doctor theDoctor) {
		
		doctorService.save(theDoctor);
		
		return theDoctor;
	}
	
	
	@DeleteMapping("/doctors/{doctorId}")
	public String deleteDoctor(@PathVariable int doctorId) {
		
		Doctor tempDoctor = doctorService.findById(doctorId);
		
				
		if (tempDoctor == null) {
			throw new RuntimeException("Doctor id not found - " + doctorId);
		}
		
		doctorService.deleteById(doctorId);
		
		return "Deleted Doctor id - " + doctorId;
	}
	
}










