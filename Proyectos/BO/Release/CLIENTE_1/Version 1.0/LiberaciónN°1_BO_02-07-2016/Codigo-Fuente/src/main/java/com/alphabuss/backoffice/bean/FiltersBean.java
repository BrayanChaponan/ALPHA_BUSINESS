package com.alphabuss.backoffice.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
@ViewScoped
public class FiltersBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EL_NAME = "#{filtersBean}";

	private String dateStart;
	private String dateEnd;
	private String dateStartDB;
	private String dateEndDB;

	@PostConstruct
	public void init() {
		System.out.println("INIT starting...");
		this.dateStart = GeneralUtil.getCurrentDate();
		this.dateEnd = GeneralUtil.getCurrentDate();
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDateStartDB() {
		return dateStartDB;
	}

	public void setDateStartDB(String dateStartDB) {
		this.dateStartDB = dateStartDB;
	}

	public String getDateEndDB() {
		return dateEndDB;
	}

	public void setDateEndDB(String dateEndDB) {
		this.dateEndDB = dateEndDB;
	}

	@Override
	public String toString() {
		return "FiltersBean [dateStart=" + dateStart + ", dateEnd=" + dateEnd
				+ ", dateStartDB=" + dateStartDB + ", dateEndDB=" + dateEndDB
				+ "]";
	}
}
