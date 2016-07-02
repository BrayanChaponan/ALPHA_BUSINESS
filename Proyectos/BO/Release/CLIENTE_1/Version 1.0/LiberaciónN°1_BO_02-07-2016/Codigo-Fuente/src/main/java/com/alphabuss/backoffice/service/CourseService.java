package com.alphabuss.backoffice.service;

import java.util.List;

import com.alphabuss.backoffice.model.Curso;

public interface CourseService {
	
	public List<Curso> coursesList();
	
	public Curso getCourse(Curso curso);
	
	public String courseEdit(Curso curso);

}
