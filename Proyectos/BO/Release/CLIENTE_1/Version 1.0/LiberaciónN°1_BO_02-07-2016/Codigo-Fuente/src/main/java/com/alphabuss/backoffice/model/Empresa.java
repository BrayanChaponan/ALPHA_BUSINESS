package com.alphabuss.backoffice.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "empresaMB")
@ViewScoped
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EL_NAME = "#{empresaMB}";

	private Long ruc;
	private String razonSocial;
	private String address;
	private String mobilePhone;
	private String homePhone;
	private String webPage;
	private String email;
	private Integer status;
	private Integer nroEmpleados;

	public Long getRuc() {
		return ruc;
	}

	public void setRuc(Long ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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

	public String getWebPage() {
		return webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getNroEmpleados() {
		return nroEmpleados;
	}

	public void setNroEmpleados(Integer nroEmpleados) {
		this.nroEmpleados = nroEmpleados;
	}

	@Override
	public String toString() {
		return "Empresa [ruc=" + ruc + ", razonSocial=" + razonSocial
				+ ", address=" + address + ", mobilePhone=" + mobilePhone
				+ ", homePhone=" + homePhone + ", webPage=" + webPage
				+ ", email=" + email + ", status=" + status + ", nroEmpleados="
				+ nroEmpleados + "]";
	}
}
