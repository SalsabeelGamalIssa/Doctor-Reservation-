package com.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.Date;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@Table(name="patient")
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id", unique=true, nullable=false)
	private int patientId;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date", nullable=false)
	private Date birthDate;

	@Column(length=45)
	private String gender;

	@Size(min=2)
	@Column(name="patient_name", length=45)
	private String patientName;

//	//bi-directional many-to-one association to Appointment
//	@OneToMany(mappedBy="patient")
//	private List<Appointment> appointments;

	public Patient() {
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

//	public List<Appointment> getAppointments() {
//		return this.appointments;
//	}
//
//	public void setAppointments(List<Appointment> appointments) {
//		this.appointments = appointments;
//	}

//	public Appointment addAppointment(Appointment appointment) {
//		getAppointments().add(appointment);
//		appointment.setPatient(this);
//
//		return appointment;
//	}
//
//	public Appointment removeAppointment(Appointment appointment) {
//		getAppointments().remove(appointment);
//		appointment.setPatient(null);
//
//		return appointment;
//	}

}