package com.rest.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author root
 *
 */
@Entity
public class Doctor implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1135742614337641415L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int drId;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String deparment;
	
	private String address;

	
	@Lob
	@Column(name = "pic")
	private byte[] pic;

	@Column(name = "mimetype")
	private String mimetype; 
	
	
	private String fileName;
	
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "doctor", orphanRemoval = true)
	private List<Patient> patientsList;
	


	public Doctor(String fileName, String mimetype, byte[] pic) {
		super();
		this.pic = pic;
		this.mimetype = mimetype;
		this.fileName = fileName;
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public List<Patient> getPatientsList() {
		return patientsList;
	}

	public void setPatientsList(List<Patient> patientsList) {
		this.patientsList = patientsList;
	}

	public int getDrId() {
		return drId;
	}

	public void setDrId(int drId) {
		this.drId = drId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

	
}
