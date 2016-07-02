package com.alphabuss.backoffice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphabuss.backoffice.dao.EmployeeMapper;
import com.alphabuss.backoffice.model.Empleado;
import com.alphabuss.backoffice.model.Empresa;
import com.alphabuss.backoffice.service.EmployeeService;

@Service(EmployeeServiceImpl.SERVICE_NAME)
public class EmployeeServiceImpl implements EmployeeService {

	public static final String SERVICE_NAME = "employeeServiceImpl";
	public static final String EL_NAME = "#{employeeServiceImpl}";

	private static final Logger LOG = LogManager
			.getLogger(EmployeeServiceImpl.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@Autowired
	private EmployeeMapper employeeMapper;

	/* ************************************ */
	/* Implement Methods */
	/* ************************************ */
	@Override
	public List<Empleado> employeesList() {
		LOG.info("Obteniendo lista de empleados");
		return employeeMapper.employeesList();
	}

	@Override
	public Empleado getEmployee(Empleado empleado) {
		return employeeMapper.getEmployee(empleado);
	}

	@Override
	public String employeeEdit(Empleado empleado) {

		// Si el ID es nulo, se REGISTRA
		if (empleado.getEmployeeId() == null) {

			LOG.info("se registrará " + empleado.toString());
			employeeMapper.employeeRegister(empleado);
			LOG.info("Se registró el empleado con ID -> " + empleado.getEmployeeId());

		} else {// Se ACTUALIZA			

			LOG.info("se actualizará " + empleado.toString());
			employeeMapper.employeeUpdate(empleado);
		}
		return "OK";
	}

	@Override
	public List<Empleado> employeesByRUC(Empresa empresa) {
		return employeeMapper.employeesByRUC(empresa);
	}

}
