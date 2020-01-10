package com.rest.java.dto;

import java.util.List;

import javax.persistence.Column;

public class DoctorDto {

	private int drId;

	private String name;

	private String email;

	private String phone;

	private String deparment;

	private String address;

	@Column(name = "pic")
	private byte[] pic;

	@Column(name = "mimetype")
	private String mimetype;
	
	private String fileName;

	private List<PatientDto> pntDtos;

	
	public List<PatientDto> getPntDtos() {
		return pntDtos;
	}

	public void setPntDtos(List<PatientDto> pntDtos) {
		this.pntDtos = pntDtos;
	}

	public int getDrId() {
		return drId;
	}

	public void setDrId(int drId) {
		this.drId = drId;
	}

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
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
