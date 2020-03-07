package com.task.service;
import java.util.List;

import com.task.entity.*;


public interface PatientService {

	public List<Patient> findAll();
	
	public Patient findById(int theId);
	
	public void save(Patient thePatient);
	
	public void deleteById(int theId);
	
}
