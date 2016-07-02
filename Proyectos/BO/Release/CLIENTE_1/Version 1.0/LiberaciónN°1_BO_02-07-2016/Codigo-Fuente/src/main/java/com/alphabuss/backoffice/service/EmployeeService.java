package com.alphabuss.backoffice.service;

import java.util.List;

import com.alphabuss.backoffice.model.Empleado;
import com.alphabuss.backoffice.model.Empresa;

public interface EmployeeService {
	
	public List<Empleado> employeesList();
	
	public List<Empleado> employeesByRUC(Empresa empresa);
	
	public Empleado getEmployee(Empleado empleado);
	
	public String employeeEdit(Empleado empleado);

}
