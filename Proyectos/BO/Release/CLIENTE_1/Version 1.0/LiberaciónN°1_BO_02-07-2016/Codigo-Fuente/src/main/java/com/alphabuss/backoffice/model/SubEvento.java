package com.alphabuss.backoffice.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "subEventMB")
@ViewScoped
public class SubEvento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EL_NAME = "#{subEventMB}";

	private Integer subEventId;
	private String dateStart;
	private String dateEnd;

	@ManagedProperty(value = Evento.EL_NAME)
	private Evento evento;

	@ManagedProperty(value = Curso.EL_NAME)
	private Curso curso;

	@ManagedProperty(value = Capacitador.EL_NAME)
	private Capacitador capacitador;

	public Integer getSubEventId() {
		return subEventId;
	}

	public void setSubEventId(Integer subEventId) {
		this.subEventId = subEventId;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Capacitador getCapacitador() {
		return capacitador;
	}

	public void setCapacitador(Capacitador capacitador) {
		this.capacitador = capacitador;
	}

	@Override
	public String toString() {
		return "SubEvento [subEventId=" + subEventId + ", dateStart="
				+ dateStart + ", dateEnd=" + dateEnd + ", evento=" + evento
				+ ", curso=" + curso + ", capacitador=" + capacitador + "]";
	}
}
