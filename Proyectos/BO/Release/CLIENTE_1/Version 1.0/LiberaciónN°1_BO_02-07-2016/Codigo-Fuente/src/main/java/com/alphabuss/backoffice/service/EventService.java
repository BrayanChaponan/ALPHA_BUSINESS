package com.alphabuss.backoffice.service;

import java.util.List;

import com.alphabuss.backoffice.model.Evento;
import com.alphabuss.backoffice.model.SubEvento;

public interface EventService {

	public List<Evento> eventsList();

	public Evento getEvent(Evento evento);

	public String eventEdit(Evento evento);
	
	// SubEventos (Cursos) por Evento
	public List<SubEvento> subEventsList(int eventId);
	
	public SubEvento getSubEvent(SubEvento subEvento);
	
	public void subEventUpdate(SubEvento subEvento);
	
}
