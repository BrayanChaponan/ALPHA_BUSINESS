package com.alphabuss.backoffice.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;

import com.alphabuss.backoffice.model.Evento;
import com.alphabuss.backoffice.service.EventService;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EventService eventService;

	public JsonServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("en jsonservlet GET...");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("en jsonservlet POST...");
		resp.setContentType("text/html");
		PrintWriter writerOut = resp.getWriter();
		List<Evento> eventsList = eventService.eventsList();
		String json = JSONSerializer.toJSON(eventsList).toString();
		writerOut.print(json);
	}

}
