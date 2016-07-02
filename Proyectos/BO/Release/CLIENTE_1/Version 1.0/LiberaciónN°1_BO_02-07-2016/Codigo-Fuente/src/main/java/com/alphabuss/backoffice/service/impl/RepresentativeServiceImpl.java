package com.alphabuss.backoffice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphabuss.backoffice.dao.RepresentativeMapper;
import com.alphabuss.backoffice.model.Representante;
import com.alphabuss.backoffice.service.RepresentativeService;

@Service(RepresentativeServiceImpl.SERVICE_NAME)
public class RepresentativeServiceImpl implements RepresentativeService {

	public static final String SERVICE_NAME = "representativeServiceImpl";
	public static final String EL_NAME = "#{representativeServiceImpl}";

	private static final Logger LOG = LogManager
			.getLogger(RepresentativeServiceImpl.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@Autowired
	private RepresentativeMapper representativeMapper;

	/* ************************************ */
	/* Implement Methods */
	/* ************************************ */
	@Override
	public List<Representante> representativesList() {
		LOG.info("Obteniendo lista de representates");
		return representativeMapper.representativesList();
	}

	@Override
	public Representante getRepresentative(Representante representante) {
		return representativeMapper.getRepresentative(representante);
	}

	@Override
	public String representativeEdit(Representante representante) {

		// Si el ID es nulo, se REGISTRA
		if (representante.getRepresentativeId() == null) {

			LOG.info("se registrará " + representante.toString());
			representativeMapper.representativeRegister(representante);
			LOG.info("Se registró el representante con ID -> " + representante.getRepresentativeId());

		} else {// Se ACTUALIZA			

			LOG.info("se actualizará " + representante.toString());
			representativeMapper.representativeUpdate(representante);
		}
		return "OK";
	}

}
