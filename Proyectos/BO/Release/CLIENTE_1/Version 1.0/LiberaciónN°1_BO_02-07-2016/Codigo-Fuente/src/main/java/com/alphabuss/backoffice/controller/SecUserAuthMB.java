package com.alphabuss.backoffice.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.alphabuss.backoffice.model.SecUser;
import com.alphabuss.backoffice.util.ConstantsUtil;

@ManagedBean
public class SecUserAuthMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(SecUserAuthMB.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@ManagedProperty(value = SecUser.EL_NAME)
	private SecUser secUser;

	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authenticationManager = null;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	public String userLogin() {
		try {
			LOG.debug("Parametros a logear: userName -> {} password -> {} ",
					secUser.getUserName(), secUser.getPassword());

			Authentication requestAuthentication = new UsernamePasswordAuthenticationToken(
					secUser.getUserName(), secUser.getPassword());
			Authentication resultAuthentication = authenticationManager
					.authenticate(requestAuthentication);
			SecurityContextHolder.getContext().setAuthentication(
					resultAuthentication);

		} catch (AuthenticationException e) {
			
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, null,
					"El username o password son incorrectos");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);

			LOG.error(e.getMessage());

			return null;
		} catch (NullPointerException e) {
			System.out.println("NULO");
		}
		return ConstantsUtil.PAGE_INDEX
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}

	public String logout() {
		LOG.info("Cerrando sesion");
		SecurityContextHolder.clearContext();
		return ConstantsUtil.PAGE_LOGIN
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public SecUser getSecUser() {
		return secUser;
	}

	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}

}
