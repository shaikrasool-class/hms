package com.rest.java.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * The Hospital Object Contain details of about Hospital
 * 
 * Represents an Hospital
 * 
 * 
 * @author Shaik
 *
 */

@Entity
@Table(name="hospital")
public class Hospital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Unique Identifier of the Hospital
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hospId")
	private Integer hospId;

	/**
	 * Name of the Hospital
	 */

	@Column(length = 25, nullable = false, unique = true)
	private String name;

	/**
	 * email of the Hospital
	 */

	@Column(length = 50, nullable = false, unique = true)
	private String email;

	/**
	 * Phone number of the Hospital
	 */
	@Column(length = 12, unique = true , nullable = false)
	private String phone;

	/**
	 * fax number of the Hospital
	 */

	@Column(length = 12, nullable = false, unique = true)
	private String fax;
	

	/**
	 * address of the Hospital
	 */

	private String address;
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getHospId() {
		return hospId;
	}

	public void setHospId(Integer hospId) {
		this.hospId = hospId;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	
}