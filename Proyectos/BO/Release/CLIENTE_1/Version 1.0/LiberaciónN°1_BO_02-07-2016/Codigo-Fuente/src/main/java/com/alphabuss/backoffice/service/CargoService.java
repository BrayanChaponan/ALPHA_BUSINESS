package com.alphabuss.backoffice.service;

import java.util.List;

import com.alphabuss.backoffice.model.Cargo;

public interface CargoService {

	public List<Cargo> cargosList();

	public Cargo getCargo(Cargo cargo);

	public String cargoEdit(Cargo cargo);

}
