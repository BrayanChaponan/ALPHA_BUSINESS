package com.alphabuss.backoffice.service;

import java.util.List;

import com.alphabuss.backoffice.model.SecRole;

public interface RoleService {
	
	public List<SecRole> rolesList();
	
	public SecRole getRole(SecRole secRole);
	
	public String roleEdit(SecRole secRole);

}
