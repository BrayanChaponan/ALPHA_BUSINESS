package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.Capacitador;

public interface TrainerMapper {
	
	public List<Capacitador> trainersList();
	
	public Capacitador getTrainer(Capacitador capacitador);
	
	public void trainerRegister(Capacitador capacitador);
	
	public void trainerUpdate(Capacitador capacitador);

}
