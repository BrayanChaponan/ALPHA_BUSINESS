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
import com.alphabuss.backoffice.model.SecUser;
import com.alphabuss.backoffice.service.RoleService;
import com.alphabuss.backoffice.service.UserService;
import com.alphabuss.backoffice.service.impl.RoleServiceImpl;
import com.alphabuss.backoffice.service.impl.UserServiceImpl;
import com.alphabuss.backoffice.util.ConstantsUtil;
import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
public class UserMaintenanceMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(UserMaintenanceMB.class);

	/* ************************************ */
	/* Attributes */
	/* ************************************ */
	private List<SecUser> usersList;
	private List<SecRole> rolesList;

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */
	@ManagedProperty(value = UserServiceImpl.EL_NAME)
	private UserService userService;

	@ManagedProperty(value = RoleServiceImpl.EL_NAME)
	private RoleService roleService;

	@ManagedProperty(value = SecUser.EL_NAME)
	private SecUser secUser;

	// @ManagedProperty(value = FiltersBean.EL_NAME)
	// private FiltersBean filtersBean;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	// Metodo que es ejecutado al cargar la pagina de mantenimiento para cargar
	// la lista de usuarios segun los filtros por defecto, antes de renderizar
	// la vista
	public void load() {
		LOG.info("LOAD starting... ");
		list();
	}

	// Metodo que es ejecutado al cargar la pagina de edit, para cargar la data
	public void userLoad() {
		LOG.info("USERLOAD starting... ");

		if (secUser.getUserId() != null) {
			LOG.info("se editara el userId -> {}", secUser.getUserId());
			secUser = userService.getUser(secUser);
		}
		// Cargar roles
		LOG.info("se cargaran los roles");
		rolesList = roleService.rolesList();
		GeneralUtil.putViewMap("rolesList", rolesList);
	}

	// Metodo que lista los usuarios
	public String list() {
		LOG.info("LIST starting... ");
		usersList = userService.usersList();
		if (usersList != null) {
			GeneralUtil.putViewMap("usersList", usersList);
		}
		return null;
	}

	// Metodo que registra o actualiza un usuario
	public String edit() {
		LOG.info("EDIT starting...");

		// Validar contraseña y su confirmacion
		if (!secUser.getPassword().equals(secUser.getConfirmPassword())) {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, null,
					"Las contraseñas no coinciden");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return null;
		}

		String userEditResult = userService.userEdit(secUser);
		
		if (userEditResult.equals("USERNAME_REGISTERED")) {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, null,
					"El nombre de usuario ya se encuentra registrado");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return null;
		}
		
		return ConstantsUtil.PAGE_USER_MAINTENANCE
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}
	
	public void changeStatus(SecUser secUser){
		LOG.info("changeStatus starting...");
		LOG.info("SECUSER... {} ", secUser.toString());
		
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SecUser getSecUser() {
		return secUser;
	}

	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}

	public List<SecUser> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<SecUser> usersList) {
		this.usersList = usersList;
	}

	// public FiltersBean getFiltersBean() {
	// return filtersBean;
	// }
	//
	// public void setFiltersBean(FiltersBean filtersBean) {
	// this.filtersBean = filtersBean;
	// }

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

}
