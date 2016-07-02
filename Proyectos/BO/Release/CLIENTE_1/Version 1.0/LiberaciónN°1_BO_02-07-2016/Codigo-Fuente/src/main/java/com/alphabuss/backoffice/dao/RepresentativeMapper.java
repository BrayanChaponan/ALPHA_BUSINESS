package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.Representante;

public interface RepresentativeMapper {
	
	public List<Representante> representativesList();
	
	public Representante getRepresentative(Representante representante);
	
	public void representativeRegister(Representante representante);
	
	public void representativeUpdate(Representante representante);

}
