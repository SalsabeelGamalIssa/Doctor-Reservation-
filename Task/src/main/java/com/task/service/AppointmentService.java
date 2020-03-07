package com.task.service;
import java.util.List;

import com.task.entity.*;


public interface AppointmentService {

	public List<Appointment> findAll();
	
	public Appointment findById(int theId);
	
	public void save(Appointment theAppointment);
	
	public void deleteById(int theId);
	
}
