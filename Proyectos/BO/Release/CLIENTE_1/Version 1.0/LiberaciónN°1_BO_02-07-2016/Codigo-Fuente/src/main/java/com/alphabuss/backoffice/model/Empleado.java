package com.alphabuss.backoffice.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "empleadoMB")
@ViewScoped
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EL_NAME = "#{empleadoMB}";

	private Integer employeeId;
	private String dni;
	private String firstName;
	private String lastName;
	private String email;
	private Integer status;

	@ManagedProperty(value = Cargo.EL_NAME)
	private Cargo cargo;

	@ManagedProperty(value = Empresa.EL_NAME)
	private Empresa empresa;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Empleado [employeeId=" + employeeId + ", dni=" + dni
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", status=" + status + ", cargo="
				+ cargo + ", empresa=" + empresa + "]";
	}

}
