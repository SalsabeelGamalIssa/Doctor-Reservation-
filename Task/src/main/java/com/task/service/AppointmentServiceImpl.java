package com.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.*;
import com.task.entity.*;


@Service
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentResp appointmentResp;
	
	@Autowired
	public AppointmentServiceImpl(AppointmentResp theappointmentResp) {
		appointmentResp = theappointmentResp;
	}
	
	@Override
	@Transactional
	public List<Appointment> findAll() {
		return appointmentResp.findAll();
	}

	@Override
	@Transactional
	public Appointment findById(int theId) {
		Optional<Appointment> result=appointmentResp.findById(theId);
		Appointment doc=null;
		
		if(result.isPresent()) {
			doc=result.get();
		}
		else
		{
			throw new RuntimeException(" no Appointment ll id da "+theId);
		}
		return doc;	}

	@Override
	@Transactional
	public void save(Appointment theAppointment) {
		appointmentResp.save(theAppointment);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		appointmentResp.deleteById(theId);
	}

}






