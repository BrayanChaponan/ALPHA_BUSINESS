package com.alphabuss.backoffice.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "eventMB")
@ViewScoped
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String EL_NAME = "#{eventMB}";

	private Integer eventId;
	private String name;
	private Integer quotasTotal;
	private Integer quotasRegistered;
	private Integer quotasAvailable;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuotasTotal() {
		return quotasTotal;
	}

	public void setQuotasTotal(Integer quotasTotal) {
		this.quotasTotal = quotasTotal;
	}

	public Integer getQuotasRegistered() {
		return quotasRegistered;
	}

	public void setQuotasRegistered(Integer quotasRegistered) {
		this.quotasRegistered = quotasRegistered;
	}

	public Integer getQuotasAvailable() {
		return quotasAvailable;
	}

	public void setQuotasAvailable(Integer quotasAvailable) {
		this.quotasAvailable = quotasAvailable;
	}

	@Override
	public String toString() {
		return "Evento [eventId=" + eventId + ", name=" + name
				+ ", quotasTotal=" + quotasTotal + ", quotasRegistered="
				+ quotasRegistered + ", quotasAvailable=" + quotasAvailable
				+ "]";
	}

}
