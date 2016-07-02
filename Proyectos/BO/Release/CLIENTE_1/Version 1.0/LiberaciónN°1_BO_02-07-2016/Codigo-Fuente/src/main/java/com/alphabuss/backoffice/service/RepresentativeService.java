package com.alphabuss.backoffice.service;

import java.util.List;

import com.alphabuss.backoffice.model.Representante;

public interface RepresentativeService {
	
	public List<Representante> representativesList();
	
	public Representante getRepresentative(Representante representante);
	
	public String representativeEdit(Representante representante);

}
