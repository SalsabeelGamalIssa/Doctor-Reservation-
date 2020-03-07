package com.task.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entity.*;


public interface PatientResp extends JpaRepository<Patient, Integer> {

}
