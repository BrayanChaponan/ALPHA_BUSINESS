package com.alphabuss.backoffice.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cargoMB")
@ViewScoped
public class Cargo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EL_NAME = "#{cargoMB}";

	private Integer cargoId;
	private String name;
	private String description;

	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Cargo [cargoId=" + cargoId + ", name=" + name
				+ ", description=" + description + "]";
	}

}
