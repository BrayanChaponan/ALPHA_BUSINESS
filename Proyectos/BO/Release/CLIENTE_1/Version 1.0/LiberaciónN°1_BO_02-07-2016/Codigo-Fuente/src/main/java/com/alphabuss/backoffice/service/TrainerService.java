package com.alphabuss.backoffice.service;

import java.util.List;

import com.alphabuss.backoffice.model.Capacitador;

public interface TrainerService {
	
	public List<Capacitador> trainersList();
	
	public Capacitador getTrainer(Capacitador capacitador);
	
	public String trainerEdit(Capacitador capacitador);

}
