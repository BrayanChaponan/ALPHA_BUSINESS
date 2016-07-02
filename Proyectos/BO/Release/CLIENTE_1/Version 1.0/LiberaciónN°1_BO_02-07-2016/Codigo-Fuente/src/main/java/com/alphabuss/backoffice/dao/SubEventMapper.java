package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.SubEvento;

public interface SubEventMapper {

	public List<SubEvento> subEventsList(int eventId);
	
	public SubEvento getSubEvent(SubEvento subEvento);	
	
	public void subEventUpdate(SubEvento subEvento);
	
	public void subEventRegister(SubEvento subEvento);
	
}
