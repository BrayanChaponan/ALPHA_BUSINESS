package com.alphabuss.backoffice.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphabuss.backoffice.model.Capacitador;
import com.alphabuss.backoffice.service.TrainerService;
import com.alphabuss.backoffice.service.impl.TrainerServiceImpl;
import com.alphabuss.backoffice.util.ConstantsUtil;
import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
public class TrainerMaintenanceMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(TrainerMaintenanceMB.class);

	/* ************************************ */
	/* Attributes */
	/* ************************************ */
	private List<Capacitador> trainersList;

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@ManagedProperty(value = TrainerServiceImpl.EL_NAME)
	private TrainerService trainerService;

	@ManagedProperty(value = Capacitador.EL_NAME)
	private Capacitador capacitador;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	// Metodo que es ejecutado al cargar la pagina de mantenimiento para cargar
	// la lista de cursos segun los filtros por defecto, antes de renderizar
	// la vista
	public void load() {
		LOG.info("LOAD starting... ");
		list();
	}

	// Metodo que es ejecutado al cargar la pagina de edit, para cargar la data
	public void editLoad() {
		LOG.info("EDITLOAD starting... ");

		if (capacitador.getCapacitadorId() != null) {
			LOG.info("se editara el empleado Id -> {}",
					capacitador.getCapacitadorId());
			capacitador = trainerService.getTrainer(capacitador);
		}
	}

	// Metodo que lista los roles
	public String list() {
		LOG.info("LIST starting... ");
		trainersList = trainerService.trainersList();
		if (trainersList != null) {
			GeneralUtil.putViewMap("trainersList", trainersList);
		}
		return null;
	}

	// Metodo que registra o actualiza un empleado
	public String edit() {
		LOG.info("EDIT starting...");

		trainerService.trainerEdit(capacitador);

		return ConstantsUtil.PAGE_TRAINER_MAINTENANCE
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public List<Capacitador> getTrainersList() {
		return trainersList;
	}

	public void setTrainersList(List<Capacitador> trainersList) {
		this.trainersList = trainersList;
	}

	public TrainerService getTrainerService() {
		return trainerService;
	}

	public void setTrainerService(TrainerService trainerService) {
		this.trainerService = trainerService;
	}

	public Capacitador getCapacitador() {
		return capacitador;
	}

	public void setCapacitador(Capacitador capacitador) {
		this.capacitador = capacitador;
	}

}
