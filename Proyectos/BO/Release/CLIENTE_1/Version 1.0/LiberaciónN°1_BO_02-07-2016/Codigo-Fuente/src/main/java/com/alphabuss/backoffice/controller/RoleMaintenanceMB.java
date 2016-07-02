package com.alphabuss.backoffice.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphabuss.backoffice.model.SecRole;
import com.alphabuss.backoffice.service.RoleService;
import com.alphabuss.backoffice.service.impl.RoleServiceImpl;
import com.alphabuss.backoffice.util.ConstantsUtil;
import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
public class RoleMaintenanceMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(RoleMaintenanceMB.class);

	/* ************************************ */
	/* Attributes */
	/* ************************************ */
	private List<SecRole> rolesList;

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@ManagedProperty(value = RoleServiceImpl.EL_NAME)
	private RoleService roleService;

	@ManagedProperty(value = SecRole.EL_NAME)
	private SecRole secRole;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	// Metodo que es ejecutado al cargar la pagina de mantenimiento para cargar
	// la lista de roles segun los filtros por defecto, antes de renderizar
	// la vista
	public void load() {
		LOG.info("LOAD starting... ");
		list();
	}

	// Metodo que es ejecutado al cargar la pagina de edit, para cargar la data
	public void editLoad() {
		LOG.info("EDITLOAD starting... ");

		if (secRole.getRoleId() != null) {
			LOG.info("se editara el roleId -> {}", secRole.getRoleId());
			secRole = roleService.getRole(secRole);
		}

	}

	// Metodo que lista los roles
	public String list() {
		LOG.info("LIST starting... ");
		rolesList = roleService.rolesList();
		if (rolesList != null) {
			GeneralUtil.putViewMap("rolesList", rolesList);
		}
		return null;
	}

	// Metodo que registra o actualiza un rol
	public String edit() {
		LOG.info("EDIT starting...");

		String roleEditResult = roleService.roleEdit(secRole);

		if (roleEditResult.equals("ROLNAME_REGISTERED")) {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, null,
					"El nombre del rol ya se encuentra registrado");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return null;
		}

		return ConstantsUtil.PAGE_ROLE_MAINTENANCE
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<SecRole> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<SecRole> rolesList) {
		this.rolesList = rolesList;
	}

	public SecRole getSecRole() {
		return secRole;
	}

	public void setSecRole(SecRole secRole) {
		this.secRole = secRole;
	}

}
