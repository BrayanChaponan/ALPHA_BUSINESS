package com.alphabuss.backoffice.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphabuss.backoffice.model.Empresa;
import com.alphabuss.backoffice.model.Representante;
import com.alphabuss.backoffice.service.CompanyService;
import com.alphabuss.backoffice.service.RepresentativeService;
import com.alphabuss.backoffice.service.impl.CompanyServiceImpl;
import com.alphabuss.backoffice.service.impl.RepresentativeServiceImpl;
import com.alphabuss.backoffice.util.ConstantsUtil;
import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
public class RepresentativeMaintenanceMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(RepresentativeMaintenanceMB.class);

	/* ************************************ */
	/* Attributes */
	/* ************************************ */
	private List<Representante> representativesList;
	private List<Empresa> companiesList;

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@ManagedProperty(value = RepresentativeServiceImpl.EL_NAME)
	private RepresentativeService representativeService;

	@ManagedProperty(value = CompanyServiceImpl.EL_NAME)
	private CompanyService companyService;

	@ManagedProperty(value = Representante.EL_NAME)
	private Representante representante;

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

		if (representante.getRepresentativeId() != null) {
			LOG.info("se editara el representante Id -> {}",
					representante.getRepresentativeId());
			representante = representativeService
					.getRepresentative(representante);
		}

		// Cargar empresas
		LOG.info("se cargaran las empresas");
		companiesList = companyService.companiesList();
		GeneralUtil.putViewMap("companiesList", companiesList);

	}

	// Metodo que lista los representantes
	public String list() {
		LOG.info("LIST starting... ");
		representativesList = representativeService.representativesList();
		if (representativesList != null) {
			GeneralUtil.putViewMap("representativesList", representativesList);
		}
		return null;
	}

	// Metodo que registra o actualiza un representante
	public String edit() {
		LOG.info("EDIT starting...");

		representativeService.representativeEdit(representante);

		return ConstantsUtil.PAGE_REPRESENTATIVE_MAINTENANCE
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public List<Representante> getRepresentativesList() {
		return representativesList;
	}

	public void setRepresentativesList(List<Representante> representativesList) {
		this.representativesList = representativesList;
	}

	public List<Empresa> getCompaniesList() {
		return companiesList;
	}

	public void setCompaniesList(List<Empresa> companiesList) {
		this.companiesList = companiesList;
	}

	public RepresentativeService getRepresentativeService() {
		return representativeService;
	}

	public void setRepresentativeService(
			RepresentativeService representativeService) {
		this.representativeService = representativeService;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
}
