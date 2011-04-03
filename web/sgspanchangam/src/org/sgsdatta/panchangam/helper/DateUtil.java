package org.sgsdatta.panchangam.helper;

import java.util.Date;

import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeFieldType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {

	/**
	 * Gets the next day.
	 * 
	 * @param gregorianDate
	 *            the gregorian date
	 * @param pattern
	 *            the pattern
	 * @return the next day
	 */
	public static String getNextDay(String gregorianDate, String pattern) {
		DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
		return format.print(format.parseDateTime(gregorianDate).plusDays(1));

	}

	/**
	 * Compare times.
	 * 
	 * @param time1
	 *            the time1
	 * @param time2
	 *            the time2
	 * @return the int
	 */
	public static int compareTimes(Date time1, Date time2) {
		DateTimeComparator comparator = DateTimeComparator.getInstance();
		return comparator.compare(time1, time2);
	}
}
