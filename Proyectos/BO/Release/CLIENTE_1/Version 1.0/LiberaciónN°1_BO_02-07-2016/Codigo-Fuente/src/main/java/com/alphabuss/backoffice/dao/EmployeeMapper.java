package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.Empleado;
import com.alphabuss.backoffice.model.Empresa;

public interface EmployeeMapper {
	
	public List<Empleado> employeesList();
	
	public List<Empleado> employeesByRUC(Empresa empresa);
	
	public Empleado getEmployee(Empleado empleado);
	
	public void employeeRegister(Empleado empleado);
	
	public void employeeUpdate(Empleado empleado);

}
