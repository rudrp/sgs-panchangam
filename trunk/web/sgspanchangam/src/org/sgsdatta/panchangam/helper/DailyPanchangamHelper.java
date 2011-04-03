package org.sgsdatta.panchangam.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.sgsdatta.panchangam.dao.PanchangamDAO;
import org.sgsdatta.panchangam.data.Nakshatram;
import org.sgsdatta.panchangam.data.Panchangam;
import org.sgsdatta.panchangam.data.Tithi;
import org.sgsdatta.panchangam.util.Constants;

public class DailyPanchangamHelper {

	/**
	 * Gets the panchangam by date.
	 * 
	 * @param gregorianDate
	 *            the gregorian date
	 * @return the panchangam by date
	 */
	public static Panchangam getPanchangamByDate(String gregorianDate) {
		PanchangamDAO dao = new PanchangamDAO();
		return dao.getPanchangamByDate(gregorianDate);
	}

	/**
	 * Gets the current panchangam.
	 * 
	 * @param gregorianDate
	 *            the gregorian date
	 * @return the current panchangam
	 */
	public static Panchangam getCurrentPanchangam(String gregorianDate) {
		return getCurrentPanchangamByTime(gregorianDate, null, null

		);
	}

	/**
	 * Gets the current panchangam by time.
	 * 
	 * @param gregorianDate
	 *            the gregorian date
	 * @param currentTime
	 *            the current time
	 * @param tZone
	 *            the t zone
	 * @return the current panchangam by time
	 */
	public static Panchangam getCurrentPanchangamByTime(String gregorianDate,
			String currentTime, String tZone) {

		Panchangam todaysPanchangam = getPanchangamByDate(gregorianDate);
		if (todaysPanchangam != null) {
			Panchangam nextDaysPanchangam = null;
			TimeZone timeZone = null;
			if (currentTime == null) {

				currentTime = new SimpleDateFormat("H:mm")
						.format(todaysPanchangam.getDay().getSunrise());
			}
			if (tZone == null) {
				timeZone = Constants.IST;
			} else {
				timeZone = TimeZone.getTimeZone(tZone);
			}

			Date currentDateTime = getDateTime(gregorianDate, currentTime,
					timeZone);
			// Tithi Calculation
			List<Tithi> todaysTithis = todaysPanchangam.getTithis();
			Tithi todaysTithi = getTithiAccordingToCurrentTime(currentDateTime,
					todaysTithis);
			if (todaysTithi == null) {
				nextDaysPanchangam = getNextDaysPanchangam(gregorianDate);
				todaysTithi = getTithiAccordingToCurrentTime(currentDateTime,
						nextDaysPanchangam.getTithis());
			}
			todaysPanchangam.setCurrentTithi(todaysTithi);

			// Nakshatram Calculation
			List<Nakshatram> todaysNakshatrams = todaysPanchangam
					.getNakshatrams();
			Nakshatram todaysNakshatram = getNakshatramAccordingToCurrentTime(
					currentDateTime, todaysNakshatrams);
			if (todaysNakshatram == null) {

				nextDaysPanchangam = nextDaysPanchangam == null ? getNextDaysPanchangam(gregorianDate)
						: nextDaysPanchangam;
				todaysNakshatram = getNakshatramAccordingToCurrentTime(
						currentDateTime, nextDaysPanchangam.getNakshatrams());
			}
			todaysPanchangam.setCurrentNakshatram(todaysNakshatram);
		}
		return todaysPanchangam;
	}

	/**
	 * Gets the nakshatram according to current time.
	 * 
	 * @param currentDateTime
	 *            the current date time
	 * @param nakshatrams
	 *            the nakshatrams
	 * @return the nakshatram according to current time
	 */
	private static Nakshatram getNakshatramAccordingToCurrentTime(
			Date currentDateTime, List<Nakshatram> nakshatrams) {
		Nakshatram todaysNakshatram = null;
		for (Nakshatram nakshatram : nakshatrams) {
			if (nakshatram.getNakshatramTime() != null) {
				if (DateUtil.compareTimes(currentDateTime,
						nakshatram.getNakshatramTime()) <= 0) {
					todaysNakshatram = nakshatram;
					break;
				}
			}
		}
		return todaysNakshatram;
	}

	/**
	 * Gets the next days panchangam.
	 * 
	 * @param gregorianDate
	 *            the gregorian date
	 * @return the next days panchangam
	 */
	private static Panchangam getNextDaysPanchangam(String gregorianDate) {
		String nextDayGregorianDate = DateUtil.getNextDay(gregorianDate,
				"dd-MM-YYYY");
		return getPanchangamByDate(nextDayGregorianDate);
	}

	/**
	 * Gets the tithi according to current time.
	 * 
	 * @param currentDateTime
	 *            the current date time
	 * @param tithis
	 *            the tithis
	 * @return the tithi according to current time
	 */
	private static Tithi getTithiAccordingToCurrentTime(Date currentDateTime,
			List<Tithi> tithis) {
		Tithi todaysTithi = null;
		for (Tithi tithi : tithis) {
			if (tithi.getTithiTime() != null) {
				if (DateUtil
						.compareTimes(currentDateTime, tithi.getTithiTime()) <= 0) {
					todaysTithi = tithi;
					break;
				}
			}
		}
		return todaysTithi;
	}

	/**
	 * Gets the date time.
	 * 
	 * @param date
	 *            the date
	 * @param time
	 *            the time
	 * @param timeZone
	 *            the time zone
	 * @return the date time
	 */
	private static Date getDateTime(String date, String time, TimeZone timeZone) {

		Calendar dateTimeCalendar = Calendar.getInstance();
		dateTimeCalendar.setTimeZone(timeZone);
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			format.setTimeZone(timeZone);
			dateTimeCalendar.setTime(format.parse(date + " " + time));
			dateTimeCalendar.setTimeZone(timeZone);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateTimeCalendar.getTime();

	}

}
