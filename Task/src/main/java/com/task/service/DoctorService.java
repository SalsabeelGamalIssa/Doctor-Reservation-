package com.task.service;
import java.util.List;

import com.task.entity.*;


public interface DoctorService {

	public List<Doctor> findAll();
	
	public Doctor findById(int theId);
	
	public void save(Doctor theDoctor);
	
	public void deleteById(int theId);
	
}
