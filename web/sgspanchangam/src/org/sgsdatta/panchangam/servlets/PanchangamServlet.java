package org.sgsdatta.panchangam.servlets;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sgsdatta.panchangam.data.Panchangam;
import org.sgsdatta.panchangam.data.Tithi;
import org.sgsdatta.panchangam.helper.DailyPanchangamHelper;
import org.sgsdatta.panchangam.util.Constants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

@SuppressWarnings("serial")
public class PanchangamServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(PanchangamServlet.class
			.getName());

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String timeZone = request.getParameter("timeZone");
		String language = request.getParameter("language");

		if("".equals(time)){
			time=null;
		}
		Panchangam panchangam = DailyPanchangamHelper
				.getCurrentPanchangamByTime(date, time, timeZone);
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
					@Override
					public JsonElement serialize(Date arg0, Type arg1,
							JsonSerializationContext arg2) {
						DateFormat format = new SimpleDateFormat("H:mm (dd/MM)");
						format.setTimeZone(Constants.IST);
						return new JsonPrimitive(format.format(arg0));
					}
				}).excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(panchangam);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
}
