package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.Empresa;

public interface CompanyMapper {

	public List<Empresa> companiesList();

	public Empresa getCompany(Empresa empresa);

	public void updateCompany(Empresa empresa);

	public void addCompany(Empresa empresa);

}
