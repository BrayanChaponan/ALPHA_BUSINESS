package com.alphabuss.backoffice.model;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SecUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EL_NAME = "#{secUser}";

	private Integer userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String status;
	private Integer invalidAttemps;
	private Date datetimeIns;
	private Integer roleId;
	private Integer statusInt;
	private boolean statusBool;

	@ManagedProperty(value = SecRole.EL_NAME)
	private SecRole secRole;

	private String confirmPassword;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getInvalidAttemps() {
		return invalidAttemps;
	}

	public void setInvalidAttemps(Integer invalidAttemps) {
		this.invalidAttemps = invalidAttemps;
	}

	public Date getDatetimeIns() {
		return datetimeIns;
	}

	public void setDatetimeIns(Date datetimeIns) {
		this.datetimeIns = datetimeIns;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public SecRole getSecRole() {
		return secRole;
	}

	public void setSecRole(SecRole secRole) {
		this.secRole = secRole;
	}	

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getStatusInt() {
		return statusInt;
	}

	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}

	public boolean isStatusBool() {
		return statusBool;
	}

	public void setStatusBool(boolean statusBool) {
		this.statusBool = statusBool;
	}

	@Override
	public String toString() {
		return "SecUser [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", status="
				+ status + ", invalidAttemps=" + invalidAttemps
				+ ", datetimeIns=" + datetimeIns + ", roleId=" + roleId
				+ ", statusInt=" + statusInt + ", statusBool=" + statusBool
				+ ", secRole=" + secRole + ", confirmPassword="
				+ confirmPassword + "]";
	}


}
