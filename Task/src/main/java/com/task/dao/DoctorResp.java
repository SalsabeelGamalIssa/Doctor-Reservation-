package com.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entity.*;
public interface DoctorResp extends JpaRepository<Doctor, Integer> {
	
	

}
