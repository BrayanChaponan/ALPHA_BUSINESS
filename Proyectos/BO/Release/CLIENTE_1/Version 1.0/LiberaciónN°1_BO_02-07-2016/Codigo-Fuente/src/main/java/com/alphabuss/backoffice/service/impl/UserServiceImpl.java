package com.alphabuss.backoffice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphabuss.backoffice.dao.UserMapper;
import com.alphabuss.backoffice.model.SecUser;
import com.alphabuss.backoffice.service.UserService;

@Service(UserServiceImpl.SERVICE_NAME)
public class UserServiceImpl implements UserService {

	public static final String SERVICE_NAME = "userServiceImpl";
	public static final String EL_NAME = "#{userServiceImpl}";

	private static final Logger LOG = LogManager
			.getLogger(UserServiceImpl.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@Autowired
	private UserMapper userMapper;

	/* ************************************ */
	/* Implement Methods */
	/* ************************************ */

	@Override
	public String userEdit(SecUser secUser) {
		
		// Consultasr si el UserName no esta registrado
		SecUser user = userMapper.validateRegisteredUserName(secUser);

		// Si el ID es nulo, se REGISTRA
		if (secUser.getUserId() == null) {
			
			// Validar que el UserName no este registrado			
			if (user != null) {
				return "USERNAME_REGISTERED";
			}
			
			LOG.info("se registrará " + secUser.toString());
			userMapper.userRegister(secUser);
			LOG.info("Se registró el usuario con ID -> " + secUser.getUserId());
			
		} else {// Se ACTUALIZA
			
			// Validar que el UserName a actualizar no este registrado
			if (user != null
					&& user.getUserId() != secUser.getUserId()) {
				return "USERNAME_REGISTERED";
			}
			
			LOG.info("se actualizará " + secUser.toString());
			userMapper.userUpdate(secUser);
		}
		return "OK";
	}

	@Override
	public List<SecUser> usersList() {
		// filtersBean.setDateStartDB(GeneralUtil.getDateFormatDB(filtersBean
		// .getDateStart()));
		// filtersBean.setDateEndDB(GeneralUtil.getDateFormatDB(filtersBean
		// .getDateEnd()));
		return userMapper.usersList();
	}

	@Override
	public SecUser getUser(SecUser secUser) {
		return userMapper.getUser(secUser);
	}

}
