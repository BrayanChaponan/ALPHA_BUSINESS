package com.alphabuss.backoffice.service;

import java.util.List;

import com.alphabuss.backoffice.model.SecUser;

public interface UserService {
	
	public String userEdit(SecUser secUser);
	
//	public List<SecUser> usersList(FiltersBean filtersBean);
	
	public List<SecUser> usersList();
	
	public SecUser getUser(SecUser secUser);

}
