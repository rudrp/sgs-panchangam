package org.sgsdatta.panchangam.dao;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgsdatta.panchangam.data.Panchangam;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.helper.DAOBase;

/**
 * The Class PanchangamDAO.
 */
public class PanchangamDAO extends DAOBase {

	private static final Logger log = Logger.getLogger(PanchangamDAO.class
			.getName());
	static {
		ObjectifyService.register(Panchangam.class);
	}

	/**
	 * Gets the panchangam by date.
	 * 
	 * @param gregorianDate
	 *            the gregorian date
	 * @return the panchangam by date
	 */
	public Panchangam getPanchangamByDate(Date gregorianDate) {

		Objectify ofy = ObjectifyService.begin();
		Query<Panchangam> query = ofy.query(Panchangam.class).filter(
				"gregorianDate", gregorianDate);
		Panchangam panchangam = query.get();

		return panchangam;

	}

	/**
	 * Save panchangam.
	 * 
	 * @param panchangam
	 *            the panchangam
	 */
	public void savePanchangam(Panchangam panchangam) {
		Objectify ofy = ObjectifyService.begin();
		ofy.put(panchangam);
		if (log.isLoggable(Level.INFO)) {
			log.info("SAVED to DataStore  " + panchangam.getGregorianDate());
		}
	}
	
	/**
	 * Truncate.
	 */
	public void truncate(){
		Objectify ofy = ObjectifyService.begin();
		ofy.delete(ofy.query(Panchangam.class).fetchKeys());
		
	}

}
