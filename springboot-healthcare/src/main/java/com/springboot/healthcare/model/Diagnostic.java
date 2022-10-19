package com.springboot.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dia")
public class Diagnostic {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="center_name")
	private String centername;
	@Column(name="listof_test")
	private String listoftest;
	@Column(name="appointment_list")
	private String appointmentlist;
	public Diagnostic() {
		super();
	}
	public Diagnostic(long id, String centername, String listoftest, String appointmentlist) {
		super();
		this.id = id;
		this.centername = centername;
		this.listoftest = listoftest;
		this.appointmentlist = appointmentlist;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCentername() {
		return centername;
	}
	public void setCentername(String centername) {
		this.centername = centername;
	}
	public String getListoftest() {
		return listoftest;
	}
	public void setListoftest(String listoftest) {
		this.listoftest = listoftest;
	}
	public String getAppointmentlist() {
		return appointmentlist;
	}
	public void setAppointmentlist(String appointmentlist) {
		this.appointmentlist = appointmentlist;
	}
	
	
}