package com.alphabuss.backoffice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphabuss.backoffice.dao.CourseMapper;
import com.alphabuss.backoffice.model.Curso;
import com.alphabuss.backoffice.service.CourseService;

@Service(CourseServiceImpl.SERVICE_NAME)
public class CourseServiceImpl implements CourseService {

	public static final String SERVICE_NAME = "courseServiceImpl";
	public static final String EL_NAME = "#{courseServiceImpl}";

	private static final Logger LOG = LogManager
			.getLogger(CourseServiceImpl.class);

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@Autowired
	private CourseMapper courseMapper;

	/* ************************************ */
	/* Implement Methods */
	/* ************************************ */
	@Override
	public List<Curso> coursesList() {
		LOG.info("Obteniendo lista de cursos");
		return courseMapper.coursesList();
	}

	@Override
	public Curso getCourse(Curso curso) {
		return courseMapper.getCourse(curso);
	}

	@Override
	public String courseEdit(Curso curso) {
		// Consultar si el nombre de curso no esta registrado
		Curso cur = courseMapper.validateRegisteredCourseName(curso);

		// Si el ID es nulo, se REGISTRA
		if (curso.getCourseId() == null) {

			// Validar que el nombre de curso no este registrado
			if (cur != null) {
				return "COURSE_NAME_REGISTERED";
			}

			LOG.info("se registrará " + curso.toString());
			courseMapper.courseRegister(curso);
			LOG.info("Se registró el curso con ID -> " + curso.getCourseId());

		} else {// Se ACTUALIZA

			// Validar que el nombre de curso a actualizar no este registrado
			if (cur != null && cur.getCourseId() != curso.getCourseId()) {
				return "COURSE_NAME_REGISTERED";
			}

			LOG.info("se actualizará " + curso.toString());
			courseMapper.courseUpdate(curso);
		}
		return "OK";
	}

}
