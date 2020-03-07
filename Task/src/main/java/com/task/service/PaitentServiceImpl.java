package com.task.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.*;
import com.task.entity.*;


@Service
public class PaitentServiceImpl implements PatientService {

	private PatientResp patientResp;
	
	@Autowired
	public PaitentServiceImpl(PatientResp thePatientResp) {
		patientResp = thePatientResp;
	}
	
	@Override
	@Transactional
	public List<Patient> findAll() {
		return patientResp.findAll();
	}

	@Override
	@Transactional
	public Patient findById(int theId) {
		Optional<Patient> result=patientResp.findById(theId);
		Patient patient=null;
		
		if(result.isPresent()) {
			patient=result.get();
		}
		else
		{
			throw new RuntimeException(" no Patient ll id da "+theId);
		}
		return patient;
	}

	@Override
	@Transactional
	public void save(Patient thePatient) {
		patientResp.save(thePatient);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		patientResp.deleteById(theId);
	}

}






