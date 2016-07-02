package com.alphabuss.backoffice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphabuss.backoffice.dao.CargoMapper;
import com.alphabuss.backoffice.model.Cargo;
import com.alphabuss.backoffice.service.CargoService;

@Service(CargoServiceImpl.SERVICE_NAME)
public class CargoServiceImpl implements CargoService {

	public static final String SERVICE_NAME = "cargoServiceImpl";
	public static final String EL_NAME = "#{cargoServiceImpl}";

	private static final Logger LOG = LogManager
			.getLogger(CargoServiceImpl.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@Autowired
	private CargoMapper cargoMapper;

	/* ************************************ */
	/* Implement Methods */
	/* ************************************ */

	@Override
	public List<Cargo> cargosList() {
		LOG.info("Obteniendo lista de cargos");
		return cargoMapper.cargosList();
	}

	@Override
	public Cargo getCargo(Cargo cargo) {
		return cargoMapper.getCargo(cargo);
	}

	@Override
	public String cargoEdit(Cargo cargo) {
		// Consultar si el nombre de cargo no esta registrado
		Cargo carg = cargoMapper.validateRegisteredCargoName(cargo);

		// Si el ID es nulo, se REGISTRA
		if (cargo.getCargoId() == null) {

			// Validar que el nombre de cargo no este registrado
			if (carg != null) {
				return "CARGO_NAME_REGISTERED";
			}

			LOG.info("se registrará " + cargo.toString());
			cargoMapper.cargoRegister(cargo);
			LOG.info("Se registró el cargo con ID -> " + cargo.getCargoId());

		} else {// Se ACTUALIZA

			// Validar que el Rol Name a actualizar no este registrado
			if (carg != null && carg.getCargoId() != cargo.getCargoId()) {
				return "CARGO_NAME_REGISTERED";
			}

			LOG.info("se actualizará " + cargo.toString());
			cargoMapper.cargoUpdate(cargo);
		}
		return "OK";
	}

}
