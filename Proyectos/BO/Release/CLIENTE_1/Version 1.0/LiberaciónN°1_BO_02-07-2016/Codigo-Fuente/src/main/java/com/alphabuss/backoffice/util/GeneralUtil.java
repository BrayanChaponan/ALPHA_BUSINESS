package com.alphabuss.backoffice.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.faces.context.FacesContext;

public class GeneralUtil {

	private static Properties prop = null;

	/* Metodo que obtiene un propertie segun su key */
	public static String getProperty(String key) {
		if (prop == null) {
			prop = getPropertyFile();
		}

		return prop.getProperty(key);
	}

	/* Metodo que carga el archivo properties a la aplicacion */
	private static Properties getPropertyFile() {
		try {
			prop = new Properties();
			prop.load(GeneralUtil.class
					.getResourceAsStream("/properties/BOAlpha.properties"));
			return prop;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
	}

	// /* Metodo que obtiene un propertie segun su key */
	// public static String getMessage(String key) {
	// if (prop == null) {
	// prop = getMessageFile();
	// }
	//
	// return prop.getProperty(key);
	// }
	//
	// /* Metodo que carga el archivo properties a la aplicacion */
	// private static Properties getMessageFile() {
	// try {
	// prop = new Properties();
	// prop.load(GeneralUtil.class
	// .getResourceAsStream("/properties/PlatformMonitor.properties"));
	// return prop;
	// } catch (IOException ioe) {
	// ioe.printStackTrace();
	// return null;
	// }
	// }

	/* Metodos para agregar y eliminar objetos de los contextos Faces */

	public static void putViewMap(String key, Object value) {
		FacesContext.getCurrentInstance().getViewRoot().getViewMap()
				.put(key, value);
	}

	public static Object getViewMap(String key) {
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap()
				.get(key);
	}

	public static void putRequestMap(String key, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.put(key, value);
	}

	public static Object getRequestMap(String key) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap().get(key);
	}

	public static void removeRequestMap(String key) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.remove(key);
	}

	public static void removeViewMap(String key) {
		FacesContext.getCurrentInstance().getViewRoot().getViewMap()
				.remove(key);
	}

	public static void putSessionMap(String key, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(key, value);
	}

	public static Object getSessionMap(String key) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(key);
	}

	public static void removeSessionMap(String key) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove(key);
	}

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat(getProperty("datePattern"));
		return dateFormat.format(new Date());
	}

	// Convierte a formato yyyy-MM-dd para la base de datos
	public static String getDateFormatDB(String fecha){
		try {
			SimpleDateFormat from = new SimpleDateFormat(getProperty("datePattern"));
			SimpleDateFormat toDB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date f = from.parse(fecha);
			String fec = toDB.format(f);
			return fec;
		} catch (Exception e) {
			return null;
		}
	}

}
