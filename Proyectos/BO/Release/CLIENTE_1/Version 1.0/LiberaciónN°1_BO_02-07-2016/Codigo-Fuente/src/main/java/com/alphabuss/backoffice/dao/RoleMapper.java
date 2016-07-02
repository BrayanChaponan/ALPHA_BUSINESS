package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.SecRole;

public interface RoleMapper {
	
	public List<SecRole> rolesList();
	
	public SecRole getRole(SecRole secRole);
	
	public SecRole validateRegisteredRoleName(SecRole secRole);
	
	public void roleRegister(SecRole secRole);
	
	public void roleUpdate(SecRole secRole);

}
