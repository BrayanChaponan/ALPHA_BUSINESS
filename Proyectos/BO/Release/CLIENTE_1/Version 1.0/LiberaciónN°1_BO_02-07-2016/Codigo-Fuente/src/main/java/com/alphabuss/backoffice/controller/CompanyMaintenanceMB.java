package com.alphabuss.backoffice.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphabuss.backoffice.model.Empleado;
import com.alphabuss.backoffice.model.Empresa;
import com.alphabuss.backoffice.service.CompanyService;
import com.alphabuss.backoffice.service.EmployeeService;
import com.alphabuss.backoffice.service.impl.CompanyServiceImpl;
import com.alphabuss.backoffice.service.impl.EmployeeServiceImpl;
import com.alphabuss.backoffice.util.ConstantsUtil;
import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
public class CompanyMaintenanceMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(CompanyMaintenanceMB.class);

	/* ************************************ */
	/* Attributes */
	/* ************************************ */

	private List<Empresa> companiesList;
	private List<Empleado> employeeList;

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@ManagedProperty(value = CompanyServiceImpl.EL_NAME)
	private CompanyService companyService;
	
	@ManagedProperty(value = EmployeeServiceImpl.EL_NAME)
	private EmployeeService employeeService;

	@ManagedProperty(value = Empresa.EL_NAME)
	private Empresa empresa;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	// Metodo que es ejecutado al cargar la pagina de mantenimiento para cargar
	// la lista de empresas segun los filtros por defecto, antes de renderizar
	// la vista
	public void load() {
		LOG.info("LOAD starting... ");
		list();
	}

	// Metodo que es ejecutado al cargar la pagina de edit, para cargar la data
	public void editLoad() {
		LOG.info("EDITLOAD starting... ");

		if (empresa.getRuc() != null) {
			LOG.info("se editara la empresa ruc -> {}", empresa.getRuc());
			empresa = companyService.getCompany(empresa);
		}
	}
	
	public String findEmployeesDetailReport(Empresa company){
		LOG.info("[findEmployeesDetailReport]starting...");
		LOG.info("parameter is: " + company);
		employeeList = employeeService.employeesByRUC(company);
		GeneralUtil.putViewMap("listEmployeeByRUC", employeeList);
		GeneralUtil.putViewMap("companyByRUC", company);
		if(employeeList!=null && !employeeList.isEmpty() && employeeList.size()>0 ){
			for(Empleado emp: employeeList){
				LOG.info(emp);
			}
			
		}
		return null;
	}
	
	// Metodo que lista las empresas
	public String list() {
		LOG.info("LIST starting... ");
		companiesList = companyService.companiesList();
		if (companiesList != null) {
			GeneralUtil.putViewMap("companiesList", companiesList);
		}
		return null;
	}

	// Metodo que registra o actualiza una empresa
	public String edit() {
		LOG.info("EDIT starting...");

		companyService.registerCompany(empresa);

		return ConstantsUtil.PAGE_COMPANY_MAINTENANCE
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public List<Empresa> getCompaniesList() {
		return companiesList;
	}

	public void setCompaniesList(List<Empresa> companiesList) {
		this.companiesList = companiesList;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
}
