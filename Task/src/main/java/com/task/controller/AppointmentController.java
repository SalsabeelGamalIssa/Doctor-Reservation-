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
public class AppointmentController {

	private AppointmentService AppointmentService;
	
	@Autowired
	public AppointmentController(AppointmentService theAppointmentService) {
		AppointmentService = theAppointmentService;
	}
	
		@GetMapping("/appointments")
	public List<Appointment> findAll() {
		return AppointmentService.findAll();
	}

		
	@GetMapping("/appointments/{appointmentId}")
	public Appointment getAppointment(@PathVariable int AppointmentId) {
		
		Appointment theAppointment = AppointmentService.findById(AppointmentId);
		
		if (theAppointment == null) {
			throw new RuntimeException("Appointment id not found - " + AppointmentId);
		}
		
		return theAppointment;
	}
	
		
	@PostMapping("/appointments")
	public Appointment addAppointmentr(@Valid @RequestBody Appointment theAppointment) {
		
	
		
		theAppointment.setAppointmentId(0);
		
		AppointmentService.save(theAppointment);
		
		return theAppointment;
	}
	
	
	@PutMapping("/appointments")
	public Appointment updateAppointment(@RequestBody Appointment theAppointment) {
		
		AppointmentService.save(theAppointment);
		
		return theAppointment;
	}
	
	
	@DeleteMapping("/appointments/{appointmentId}")
	public String deleteAppointment(@PathVariable int AppointmentId) {
		
		Appointment tempAppointment = AppointmentService.findById(AppointmentId);
		
				
		if (tempAppointment == null) {
			throw new RuntimeException("Appointment id not found - " + AppointmentId);
		}
		
		AppointmentService.deleteById(AppointmentId);
		
		return "Deleted Appointment id - " + AppointmentId;
	}
	
}










