package com.alphabuss.backoffice.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphabuss.backoffice.dao.UserMapper;
import com.alphabuss.backoffice.model.SecUser;
import com.alphabuss.backoffice.util.GeneralUtil;

@Service("userAuthService")
@Transactional(readOnly = true)
public class UserDetailsServiceAuthImpl implements UserDetailsService {

	public static final String SERVICE_NAME = "userAuthService";

	private static final Logger LOG = LogManager
			.getLogger(UserDetailsService.class);

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, NullPointerException {
		LOG.info("[loadUserByUsername] Parametro recibido: UserName -> {}",
				userName);
		User userSpring = null;

		if (userName != null) {
			SecUser secUser = new SecUser();
			secUser.setUserName(userName);
			secUser = userMapper.userLogin(secUser);

			if (secUser != null) {
				LOG.info("[loadUserByUsername] secUser -> {}",
						secUser.toString());
				
				if(secUser.getStatus().equals("I")){
					throw new NullPointerException();
				}

				boolean enabled = true;
				boolean accountNonExpired = true;
				boolean credentialsNonExpired = true;
				boolean accountNonLocked = true;

				userSpring = new User(secUser.getUserName(),
						secUser.getPassword(), enabled, accountNonExpired,
						credentialsNonExpired, accountNonLocked,
						getAuthorities(secUser.getSecRole().getRoleId()));

				LOG.info("[loadUserByUsername] userSpring -> {}",
						userSpring.toString());
				
				// Añadiendo usuario a contexto de sesion
				GeneralUtil.putSessionMap("secUserSession", secUser);
			}
		}

		return userSpring;
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 1) {
			roles.add("ROLE_ADMINISTRATOR");
			roles.add("ROLE_STANDARD");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_CAPACITADOR");
			roles.add("ROLE_STANDARD");
		} else if (role.intValue() == 3) {
			roles.add("ROLE_TERCERO");
			roles.add("ROLE_STANDARD");
		}
		return roles;
	}

}
