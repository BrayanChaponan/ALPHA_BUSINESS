package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.Evento;

public interface EventMapper {

	public List<Evento> eventsList();

	public Evento getEvent(Evento evento);

	public void eventRegister(Evento evento);

	public void eventUpdate(Evento evento);

}
