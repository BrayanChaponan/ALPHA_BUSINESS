package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.Cargo;

public interface CargoMapper {

	public List<Cargo> cargosList();

	public Cargo getCargo(Cargo cargo);
	
	public Cargo validateRegisteredCargoName(Cargo cargo);

	public void cargoRegister(Cargo cargo);

	public void cargoUpdate(Cargo cargo);

}
