package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.SecUser;

public interface UserMapper {

	public SecUser userLogin(SecUser secUser);

	public void userRegister(SecUser secUser);

	public void userUpdate(SecUser secUser);
	
	List<SecUser> usersList();
	
	public SecUser getUser(SecUser secUser);
	
	public SecUser validateRegisteredUserName(SecUser secUser);

}
