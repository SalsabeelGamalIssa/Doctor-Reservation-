package com.task.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@Table(name="doctor")
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dr_id", unique=true, nullable=false)
	private int drId;

	@Column(length=45)
	private String address;
	
	@Size(min=2)
	@Column(name="dr_name", length=45)
	private String drName;

	@Column(length=45)
	private String education;

	@Column(length=45)
	private String specialty;
//
//	//bi-directional many-to-one association to Appointment
//	@OneToMany(mappedBy="doctor")
//	private List<Appointment> appointments;

	//bi-directional many-to-one association to Doctor
//    @JsonManagedReference
//	@ManyToOne
//	 @JsonIgnore
//	@JsonView(View.Summary.class)
//	@JoinColumn(name="manager_id")
//	private Doctor doctor;

	//bi-directional many-to-one association to Doctor
//    @JsonBackReference
//	@OneToMany(mappedBy="doctor")
//	 @JsonIgnore
//	@JsonView(View.Summary.class)
//	private List<Doctor> doctors;

	public Doctor() {
	}

	public int getDrId() {
		return this.drId;
	}

	public void setDrId(int drId) {
		this.drId = drId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDrName() {
		return this.drName;
	}

	public void setDrName(String drName) {
		this.drName = drName;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

//	public List<Appointment> getAppointments() {
//		return this.appointments;
//	}

//	public void setAppointments(List<Appointment> appointments) {
//		this.appointments = appointments;
//	}

//	public Appointment addAppointment(Appointment appointment) {
//		getAppointments().add(appointment);
//		appointment.setDoctor(this);
//
//		return appointment;
//	}
//
//	public Appointment removeAppointment(Appointment appointment) {
//		getAppointments().remove(appointment);
//		appointment.setDoctor(null);
//
//		return appointment;
//	}

//	public Doctor getDoctor() {
//		return this.doctor;
//	}
//
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}
//
//	public List<Doctor> getDoctors() {
//		return this.doctors;
//	}
//
//	public void setDoctors(List<Doctor> doctors) {
//		this.doctors = doctors;
//	}

//	public Doctor addDoctor(Doctor doctor) {
//		getDoctors().add(doctor);
//		doctor.setDoctor(this);
//
//		return doctor;
//	}
//
//	public Doctor removeDoctor(Doctor doctor) {
//		getDoctors().remove(doctor);
//		doctor.setDoctor(null);
//
//		return doctor;
//	}
 
	@Override
	public String toString() {
		return "Doctor [drId=" + drId + ", address=" + address + ", drName=" + drName + ", education=" + education
				+ ", specialty=" + specialty + ", doctor=" + ", doctors="
				+ "]";
	}
	
	

}