package com.alphabuss.backoffice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphabuss.backoffice.dao.CompanyMapper;
import com.alphabuss.backoffice.model.Empresa;
import com.alphabuss.backoffice.service.CompanyService;

@Service(CompanyServiceImpl.SERVICE_NAME)
public class CompanyServiceImpl implements CompanyService {

	public static final String SERVICE_NAME = "companyServiceImpl";
	public static final String EL_NAME = "#{companyServiceImpl}";

	private static final Logger LOG = LogManager
			.getLogger(CompanyServiceImpl.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@Autowired
	private CompanyMapper companyMapper;

	/* ************************************ */
	/* Implement Methods */
	/* ************************************ */

	@Override
	public List<Empresa> companiesList() {
		LOG.info("Obteniendo lista de empresas");
		return companyMapper.companiesList();
	}

	@Override
	public Empresa getCompany(Empresa empresa) {
		return companyMapper.getCompany(empresa);
	}

	@Override
	public void registerCompany(Empresa empresa) {
		if (companyMapper.getCompany(empresa) != null) {
			companyMapper.updateCompany(empresa);
		} else {
			companyMapper.addCompany(empresa);
		}
	}

}
