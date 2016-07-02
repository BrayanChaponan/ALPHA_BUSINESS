package com.alphabuss.backoffice.dao;

import java.util.List;

import com.alphabuss.backoffice.model.Curso;

public interface CourseMapper {
	
	public List<Curso> coursesList();
	
	public Curso getCourse(Curso curso);
	
	public Curso validateRegisteredCourseName(Curso curso);
	
	public void courseRegister(Curso curso);
	
	public void courseUpdate(Curso curso);

}
