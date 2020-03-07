package com.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.*;
import com.task.entity.*;



@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorResp doctorResp;
	
	@Autowired
	public DoctorServiceImpl(DoctorResp theDoctorResp) {
		doctorResp = theDoctorResp;
	}
	
	@Override
	@Transactional
	public List<Doctor> findAll() {
		return doctorResp.findAll();
	}

	@Override
	@Transactional
	public Doctor findById(int theId) {
		Optional<Doctor> result=doctorResp.findById(theId);
		Doctor doc=null;
		
		if(result.isPresent()) {
			doc=result.get();
		}
		else
		{
			throw new RuntimeException(" no Doctor ll id da "+theId);
		}
		return doc;
	}

	@Override
	@Transactional
	public void save(Doctor theDoctor) {
		doctorResp.save(theDoctor);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		doctorResp.deleteById(theId);
	}

}






