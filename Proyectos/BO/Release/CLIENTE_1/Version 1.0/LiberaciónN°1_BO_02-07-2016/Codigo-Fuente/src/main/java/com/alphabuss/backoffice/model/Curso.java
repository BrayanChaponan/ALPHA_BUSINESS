package com.alphabuss.backoffice.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cursoMB")
@ViewScoped
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EL_NAME = "#{cursoMB}";

	private Integer courseId;
	private String name;
	private String description;
	private Double price;
	private Integer status;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Curso [courseId=" + courseId + ", name=" + name
				+ ", description=" + description + ", price=" + price
				+ ", status=" + status + "]";
	}

}
