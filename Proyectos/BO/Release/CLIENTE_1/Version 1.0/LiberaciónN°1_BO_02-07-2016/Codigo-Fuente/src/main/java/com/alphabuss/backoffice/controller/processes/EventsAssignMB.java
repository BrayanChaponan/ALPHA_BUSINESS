package com.alphabuss.backoffice.controller.processes;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.sf.json.JSONSerializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphabuss.backoffice.bean.Calendar;
import com.alphabuss.backoffice.model.Capacitador;
import com.alphabuss.backoffice.model.Curso;
import com.alphabuss.backoffice.model.Evento;
import com.alphabuss.backoffice.model.SubEvento;
import com.alphabuss.backoffice.service.CourseService;
import com.alphabuss.backoffice.service.EventService;
import com.alphabuss.backoffice.service.TrainerService;
import com.alphabuss.backoffice.service.impl.CourseServiceImpl;
import com.alphabuss.backoffice.service.impl.EventServiceImpl;
import com.alphabuss.backoffice.service.impl.TrainerServiceImpl;
import com.alphabuss.backoffice.util.ConstantsUtil;
import com.alphabuss.backoffice.util.GeneralUtil;

@ManagedBean
@ViewScoped
public class EventsAssignMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(EventsAssignMB.class);

	/* ************************************ */
	/* Attributes */
	/* ************************************ */
	private List<Evento> eventsList;
	private List<SubEvento> subEventsList;
	private List<Curso> coursesList;
	private List<Capacitador> trainersList;

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	@ManagedProperty(value = EventServiceImpl.EL_NAME)
	private EventService eventService;

	@ManagedProperty(value = CourseServiceImpl.EL_NAME)
	private CourseService courseService;

	@ManagedProperty(value = TrainerServiceImpl.EL_NAME)
	private TrainerService trainerService;

	@ManagedProperty(value = Evento.EL_NAME)
	private Evento evento;

	@ManagedProperty(value = SubEvento.EL_NAME)
	private SubEvento subEvento;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	// Es ejecutado al cargar la pagina de mantenimiento para cargar
	// la lista de eventos, antes de renderizar la vista
	public void load() {
		LOG.info("LOAD starting... ");
		list();
	}

	// Obtiene lista de eventos
	public String list() {

		LOG.info("LIST starting... ");

		if (evento != null)
			LOG.info("evento en VISTA ----- > {}", evento.toString());

		eventsList = eventService.eventsList();

		if (subEvento != null)
			LOG.info("subEvento en VISTA ----- > {}", subEvento.toString());

		return null;
	}

	// Es ejecutado al cargar la pagina de edit, para obtener la data del evento
	// seleccionado
	public void editLoad() {
		LOG.info("EDITLOAD starting... ");

		if (evento != null) {
			LOG.info("evento en VISTA ----- > {}", evento.toString());

			if (evento.getEventId() != null) {
				evento = eventService.getEvent(evento);
			}
		}
	}

	// Registra o actualiza un evento
	public String edit() {

		LOG.info("EDIT starting...");

		if (evento != null) {
			LOG.info("evento en VISTA ----- > {}", evento.toString());

			String result = eventService.eventEdit(evento);

			if (result.equals("STOCK_MIN_ERROR")) {
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, null,
						"El stock no puede ser menor al número de inscritos");
				FacesContext.getCurrentInstance()
						.addMessage(null, facesMessage);
				return null;
			}

			return ConstantsUtil.PAGE_EVENTS_ASSIGN
					.concat(ConstantsUtil.FACES_REDIRECT_TRUE);
		} else {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, null, "Ocurrió un ERROR");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return null;
		}

	}

	// Obtiene lista de sub eventos del evento seleccionado
	public String getSubEventsByEventId() {

		LOG.info("getSubEventsByEventId starting...");

		if (evento.getEventId() != null) {
			// Obtener sub eventos por eventId
			subEventsList = eventService.subEventsList(evento.getEventId());

			// Crear lista de subEventos para Calendario
			List<Calendar> calendarsList = new ArrayList<Calendar>();
			for (SubEvento se : subEventsList) {

				Random random = new Random();
				float r = random.nextFloat();
				float g = random.nextFloat();
				float b = random.nextFloat();

				Color color = new Color(r, g, b);

				Calendar c = new Calendar();
				c.setId(se.getSubEventId());
				c.setTitle(se.getCurso().getName());
				c.setStart(se.getDateStart());
				c.setEnd(se.getDateEnd());
				c.setAllDay(true);
				c.setColor("rgb(" + color.getRed() + "," + color.getGreen()
						+ "," + color.getBlue() + ")");

				calendarsList.add(c);
			}
			return JSONSerializer.toJSON(calendarsList).toString();
		}
		return null;
	}

	// Es ejecutado antes de mostrar el modal para registrar un sub evento
	public void showModalSubEventToRegister() {

		if (evento.getEventId() != null) {
			// Limpiar de contexto vista al objeto subEvento
			//subEvento = null;
//
//			evento = eventService.getEvent(evento);
//			subEvento.setEvento(evento);
			
			
			//LOG.info("subEvento!!! {}", subEvento.toString());

			// Cargar cursos
			coursesList = courseService.coursesList();

			// Cargar capacitadores
			trainersList = trainerService.trainersList();

		} else {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, null, "Ocurrió un Error");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return;
		}
	}

	// Es ejecutado antes de mostrar el modal para actualizar el sub evento
	// seleccionado
	public void showModalSubEventToUpdate() {
		LOG.info("showModalSubEventToUpdate starting...");
		LOG.info("subEvento en vista ... {}", subEvento.toString());

		// Obtener datos del subEvento por Id para actualizar
		if (subEvento.getSubEventId() != null && subEvento.getSubEventId() != 0) {

			subEvento = eventService.getSubEvent(subEvento);

			// Cargar cursos
			coursesList = courseService.coursesList();

			// Cargar capacitadores
			trainersList = trainerService.trainersList();
		} else {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, null, "Ocurrió un Error");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return;
		}
	}

	// Metodo que registra o actualiza un subEvento
	public String editSubEvent() {
		LOG.info("EDIT SUBEVENT starting...");
		if (subEvento != null) {
			LOG.info("subEvento en VISTA ----- > {}", subEvento.toString());
			eventService.subEventUpdate(subEvento);
		}
		return null;
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public List<Evento> getEventsList() {
		return eventsList;
	}

	public void setEventsList(List<Evento> eventsList) {
		this.eventsList = eventsList;
	}

	public List<SubEvento> getSubEventsList() {
		return subEventsList;
	}

	public void setSubEventsList(List<SubEvento> subEventsList) {
		this.subEventsList = subEventsList;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public SubEvento getSubEvento() {
		return subEvento;
	}

	public void setSubEvento(SubEvento subEvento) {
		this.subEvento = subEvento;
	}

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

	public List<Capacitador> getTrainersList() {
		return trainersList;
	}

	public void setTrainersList(List<Capacitador> trainersList) {
		this.trainersList = trainersList;
	}

	public TrainerService getTrainerService() {
		return trainerService;
	}

	public void setTrainerService(TrainerService trainerService) {
		this.trainerService = trainerService;
	}

}
