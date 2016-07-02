package com.alphabuss.backoffice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphabuss.backoffice.dao.EventMapper;
import com.alphabuss.backoffice.dao.SubEventMapper;
import com.alphabuss.backoffice.model.Evento;
import com.alphabuss.backoffice.model.SubEvento;
import com.alphabuss.backoffice.service.EventService;

@Service(EventServiceImpl.SERVICE_NAME)
public class EventServiceImpl implements EventService {

	public static final String SERVICE_NAME = "eventServiceImpl";
	public static final String EL_NAME = "#{eventServiceImpl}";

	private static final Logger LOG = LogManager
			.getLogger(EventServiceImpl.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@Autowired
	private EventMapper eventMapper;
	
	@Autowired
	private SubEventMapper subEventMapper;

	/* ************************************ */
	/* Implement Methods */
	/* ************************************ */

	@Override
	public List<Evento> eventsList() {
		LOG.info("Obteniendo lista de eventos");
		return eventMapper.eventsList();
	}

	@Override
	public Evento getEvent(Evento evento) {
		return eventMapper.getEvent(evento);
	}

	@Override
	public String eventEdit(Evento evento) {
		// Si el ID es nulo, se REGISTRA
		if (evento.getEventId() == null) {

			LOG.info("se registrará " + evento.toString());
			eventMapper.eventRegister(evento);
			LOG.info("Se registró el evento con ID -> " + evento.getEventId());

		} else {// Se ACTUALIZA

			// Validar que el stock no sea minimo al numero de inscritos
			if(evento.getQuotasTotal() < evento.getQuotasRegistered()){
				return "STOCK_MIN_ERROR";
			}
			
			LOG.info("se actualizará " + evento.toString());
			eventMapper.eventUpdate(evento);
		}
		return "OK";
	}

	@Override
	public List<SubEvento> subEventsList(int eventId) {
		
		List<SubEvento> subEventsList = subEventMapper.subEventsList(eventId);
		LOG.info("SIZE SUBEVENTLIST {}", subEventsList.size());
		
		return subEventsList;
	}

	@Override
	public SubEvento getSubEvent(SubEvento subEvento) {
		return subEventMapper.getSubEvent(subEvento);
	}

	@Override
	public void subEventUpdate(SubEvento subEvento) {
		// Se actualiza
		if(subEvento.getSubEventId() != null && subEvento.getSubEventId() != 0){
			subEventMapper.subEventUpdate(subEvento);
		}else{ // Se registra
			subEventMapper.subEventRegister(subEvento);
		}
				
	}
}
