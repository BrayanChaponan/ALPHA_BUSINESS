package com.alphabuss.backoffice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphabuss.backoffice.dao.RoleMapper;
import com.alphabuss.backoffice.model.SecRole;
import com.alphabuss.backoffice.service.RoleService;

@Service(RoleServiceImpl.SERVICE_NAME)
public class RoleServiceImpl implements RoleService {

	public static final String SERVICE_NAME = "roleServiceImpl";
	public static final String EL_NAME = "#{roleServiceImpl}";

	private static final Logger LOG = LogManager
			.getLogger(RoleServiceImpl.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@Autowired
	private RoleMapper roleMapper;

	/* ************************************ */
	/* Implement Methods */
	/* ************************************ */

	@Override
	public List<SecRole> rolesList() {
		LOG.info("Obteniendo lista de roles");
		return roleMapper.rolesList();
	}

	@Override
	public SecRole getRole(SecRole secRole) {
		return roleMapper.getRole(secRole);
	}

	@Override
	public String roleEdit(SecRole secRole) {
		// Consultar si el UserName no esta registrado
		SecRole role = roleMapper.validateRegisteredRoleName(secRole);

		// Si el ID es nulo, se REGISTRA
		if (secRole.getRoleId() == null) {

			// Validar que el Rol Name no este registrado
			if (role != null) {
				return "ROLNAME_REGISTERED";
			}

			LOG.info("se registrará " + secRole.toString());
			roleMapper.roleRegister(secRole);
			LOG.info("Se registró el rol con ID -> " + secRole.getRoleId());

		} else {// Se ACTUALIZA

			// Validar que el Rol Name a actualizar no este registrado
			if (role != null && role.getRoleId() != secRole.getRoleId()) {
				return "ROLNAME_REGISTERED";
			}

			LOG.info("se actualizará " + secRole.toString());
			roleMapper.roleUpdate(secRole);
		}
		return "OK";
	}

}
