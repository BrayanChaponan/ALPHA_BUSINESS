package com.alphabuss.backoffice.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphabuss.backoffice.model.Cargo;
import com.alphabuss.backoffice.model.Empleado;
import com.alphabuss.backoffice.model.Empresa;
import com.alphabuss.backoffice.service.CargoService;
import com.alphabuss.backoffice.service.CompanyService;
import com.alphabuss.backoffice.service.EmployeeService;
import com.alphabuss.backoffice.service.impl.CargoServiceImpl;
import com.alphabuss.backoffice.service.impl.CompanyServiceImpl;
import com.alphabuss.backoffice.service.impl.EmployeeServiceImpl;
import com.alphabuss.backoffice.util.ConstantsUtil;
import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
public class EmployeeMaintenanceMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(EmployeeMaintenanceMB.class);

	/* ************************************ */
	/* Attributes */
	/* ************************************ */
	private List<Empleado> employeesList;
	private List<Cargo> cargosList;
	private List<Empresa> companiesList;

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@ManagedProperty(value = EmployeeServiceImpl.EL_NAME)
	private EmployeeService employeeService;

	@ManagedProperty(value = CargoServiceImpl.EL_NAME)
	private CargoService cargoService;

	@ManagedProperty(value = CompanyServiceImpl.EL_NAME)
	private CompanyService companyService;

	@ManagedProperty(value = Empleado.EL_NAME)
	private Empleado empleado;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	// Metodo que es ejecutado al cargar la pagina de mantenimiento para cargar
	// la lista de cursos segun los filtros por defecto, antes de renderizar
	// la vista
	public void load() {
		LOG.info("LOAD starting... ");
		list();
	}

	// Metodo que es ejecutado al cargar la pagina de edit, para cargar la data
	public void editLoad() {
		LOG.info("EDITLOAD starting... ");

		if (empleado.getEmployeeId() != null) {
			LOG.info("se editara el empleado Id -> {}",
					empleado.getEmployeeId());
			empleado = employeeService.getEmployee(empleado);
		}

		// Cargar cargos
		LOG.info("se cargaran los cargos");
		cargosList = cargoService.cargosList();
		GeneralUtil.putViewMap("cargosList", cargosList);

		// Cargar empresas
		LOG.info("se cargaran las empresas");
		companiesList = companyService.companiesList();
		GeneralUtil.putViewMap("companiesList", companiesList);

	}

	// Metodo que lista los empleados
	public String list() {
		LOG.info("LIST starting... ");
		employeesList = employeeService.employeesList();
		if (employeesList != null) {
			GeneralUtil.putViewMap("employeesList", employeesList);
		}
		return null;
	}

	// Metodo que registra o actualiza un empleado
	public String edit() {
		LOG.info("EDIT starting...");

		employeeService.employeeEdit(empleado);

		return ConstantsUtil.PAGE_EMPLOYEE_MAINTENANCE
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public List<Empleado> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Empleado> employeesList) {
		this.employeesList = employeesList;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Cargo> getCargosList() {
		return cargosList;
	}

	public void setCargosList(List<Cargo> cargosList) {
		this.cargosList = cargosList;
	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}

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

}
