package org.sgsdatta.panchangam.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.sgsdatta.panchangam.data.loader.PanchangamDataLoader;

public class PanchangamApplicationListener implements ServletContextListener {

	/** The log. */
	private static Logger log = null;

	/* Application Startup Event */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent ce) {

		log = Logger.getLogger(this.getClass().getName());
		if (log.isLoggable(Level.INFO)) {
			log.info("Panchangam Application Started");
		}
		PanchangamDataLoader dataLoader = new PanchangamDataLoader();
		try {
			//PanchangamApplicationListener.class.getClassLoader().loadClass("/com/google/appengine/repackaged/org/joda/time/LocalTime");
			dataLoader.loadData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	/* Application Shutdown Event */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent ce) {
		if (log.isLoggable(Level.INFO)) {
			log.info("Panchangam Application Stopped " + ce.toString());
		}
	}
}
