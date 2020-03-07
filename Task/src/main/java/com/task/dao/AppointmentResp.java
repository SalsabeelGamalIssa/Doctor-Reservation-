package com.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entity.*;

public interface AppointmentResp extends JpaRepository<Appointment, Integer> {

}
