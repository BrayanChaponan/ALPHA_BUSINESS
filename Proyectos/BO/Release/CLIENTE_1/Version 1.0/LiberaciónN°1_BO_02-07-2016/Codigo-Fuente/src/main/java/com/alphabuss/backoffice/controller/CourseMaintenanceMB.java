package com.alphabuss.backoffice.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphabuss.backoffice.model.Curso;
import com.alphabuss.backoffice.service.CourseService;
import com.alphabuss.backoffice.service.impl.CourseServiceImpl;
import com.alphabuss.backoffice.util.ConstantsUtil;
import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
public class CourseMaintenanceMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(CourseMaintenanceMB.class);

	/* ************************************ */
	/* Attributes */
	/* ************************************ */
	private List<Curso> coursesList;

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@ManagedProperty(value = CourseServiceImpl.EL_NAME)
	private CourseService courseService;

	@ManagedProperty(value = Curso.EL_NAME)
	private Curso curso;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	// Metodo que es ejecutado al cargar la pagina de mantenimiento para cargar
	// la lista de cursos segun los filtros por defecto, antes de renderizar
	// la vista
	public void load() {
		LOG.info("LOAD starting... ");
		list();
	}

	// Metodo que es ejecutado al cargar la pagina de edit, para cargar la data
	public void editLoad() {
		LOG.info("EDITLOAD starting... ");

		if (curso.getCourseId() != null) {
			LOG.info("se editara el curso Id -> {}", curso.getCourseId());
			curso = courseService.getCourse(curso);
		}

	}

	// Metodo que lista los roles
	public String list() {
		LOG.info("LIST starting... ");
		coursesList = courseService.coursesList();
		if (coursesList != null) {
			GeneralUtil.putViewMap("coursesList", coursesList);
		}
		return null;
	}

	// Metodo que registra o actualiza un curso
	public String edit() {
		LOG.info("EDIT starting...");

		String courseEditResult = courseService.courseEdit(curso);

		if (courseEditResult.equals("COURSE_NAME_REGISTERED")) {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, null,
					"El nombre de curso ya se encuentra registrado");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return null;
		}

		return ConstantsUtil.PAGE_COURSE_MAINTENANCE
				.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public List<Curso> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(List<Curso> coursesList) {
		this.coursesList = coursesList;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
