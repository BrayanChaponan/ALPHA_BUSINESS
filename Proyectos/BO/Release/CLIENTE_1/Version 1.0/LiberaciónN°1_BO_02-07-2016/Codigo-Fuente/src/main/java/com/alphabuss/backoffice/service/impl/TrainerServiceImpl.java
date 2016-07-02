package com.alphabuss.backoffice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphabuss.backoffice.dao.TrainerMapper;
import com.alphabuss.backoffice.model.Capacitador;
import com.alphabuss.backoffice.service.TrainerService;

@Service(TrainerServiceImpl.SERVICE_NAME)
public class TrainerServiceImpl implements TrainerService {

	public static final String SERVICE_NAME = "trainerServiceImpl";
	public static final String EL_NAME = "#{trainerServiceImpl}";

	private static final Logger LOG = LogManager
			.getLogger(TrainerServiceImpl.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@Autowired
	private TrainerMapper trainerMapper;

	/* ************************************ */
	/* Implement Methods */
	/* ************************************ */
	@Override
	public List<Capacitador> trainersList() {
		LOG.info("Obteniendo lista de empleados");
		return trainerMapper.trainersList();
	}

	@Override
	public Capacitador getTrainer(Capacitador capacitador) {
		return trainerMapper.getTrainer(capacitador);
	}

	@Override
	public String trainerEdit(Capacitador capacitador) {

		// Si el ID es nulo, se REGISTRA
		if (capacitador.getCapacitadorId() == null) {

			LOG.info("se registrará " + capacitador.toString());
			trainerMapper.trainerRegister(capacitador);
			LOG.info("Se registró el capacitador con ID -> "
					+ capacitador.getCapacitadorId());

		} else {// Se ACTUALIZA

			LOG.info("se actualizará " + capacitador.toString());
			trainerMapper.trainerUpdate(capacitador);
		}
		return "OK";
	}

}
