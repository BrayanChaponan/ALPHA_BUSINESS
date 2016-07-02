package com.alphabuss.backoffice.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphabuss.backoffice.model.Cargo;
import com.alphabuss.backoffice.service.CargoService;
import com.alphabuss.backoffice.service.impl.CargoServiceImpl;
import com.alphabuss.backoffice.util.ConstantsUtil;
import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
public class CargoMaintenanceMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(CargoMaintenanceMB.class);

	/* ************************************ */
	/* Attributes */
	/* ************************************ */
	private List<Cargo> cargosList;

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@ManagedProperty(value = CargoServiceImpl.EL_NAME)
	private CargoService cargoService;

	@ManagedProperty(value = Cargo.EL_NAME)
	private Cargo cargo;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	// Metodo que es ejecutado al cargar la pagina de mantenimiento para cargar
	// la lista de cargos segun los filtros por defecto, antes de renderizar
	// la vista
	public void load() {
		LOG.info("LOAD starting... ");
		list();
	}

	// Metodo que es ejecutado al cargar la pagina de edit, para cargar la data
	public void editLoad() {
		LOG.info("EDITLOAD starting... ");

		if (cargo.getCargoId() != null) {
			LOG.info("se editara el cargoId -> {}", cargo.getCargoId());
			cargo = cargoService.getCargo(cargo);
		}

	}

	// Metodo que lista los roles
	public String list() {
		LOG.info("LIST starting... ");
		cargosList = cargoService.cargosList();
		if (cargosList != null) {
			GeneralUtil.putViewMap("cargosList", cargosList);
		}
		return null;
	}

	// Metodo que registra o actualiza un rol
	public String edit() {
		LOG.info("EDIT starting...");

		String cargoEditResult = cargoService.cargoEdit(cargo);

		if (cargoEditResult.equals("CARGO_NAME_REGISTERED")) {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, null,
					"El nombre de cargo ya se encuentra registrado");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return null;
		}

		return ConstantsUtil.PAGE_CARGO_MAINTENANCE
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public List<Cargo> getCargosList() {
		return cargosList;
	}

	public void setCargosList(List<Cargo> cargosList) {
		this.cargosList = cargosList;
	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
