package com.alphabuss.backoffice.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "capacitadorMB")
@ViewScoped
public class Capacitador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EL_NAME = "#{capacitadorMB}";

	private Integer capacitadorId;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String mobilePhone;
	private String homePhone;
	private Integer status;

	public Integer getCapacitadorId() {
		return capacitadorId;
	}

	public void setCapacitadorId(Integer capacitadorId) {
		this.capacitadorId = capacitadorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Capacitador [capacitadorId=" + capacitadorId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + ", mobilePhone=" + mobilePhone
				+ ", homePhone=" + homePhone + ", status=" + status + "]";
	}

}
