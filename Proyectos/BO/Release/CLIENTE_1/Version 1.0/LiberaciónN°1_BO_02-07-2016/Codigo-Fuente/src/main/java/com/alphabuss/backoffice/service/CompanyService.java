package com.alphabuss.backoffice.service;

import java.util.List;

import com.alphabuss.backoffice.model.Empresa;

public interface CompanyService {

	public List<Empresa> companiesList();

	public Empresa getCompany(Empresa empresa);
	
	public void registerCompany(Empresa empresa);

}
