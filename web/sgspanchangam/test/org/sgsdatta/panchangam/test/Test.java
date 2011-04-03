package org.sgsdatta.panchangam.test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.sgsdatta.panchangam.data.Panchangam;
import org.sgsdatta.panchangam.data.loader.PanchangamDataLoader;
import org.sgsdatta.panchangam.helper.DailyPanchangamHelper;
import org.sgsdatta.panchangam.util.Constants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class Test {
	public static void main(String[] args) {

		Panchangam panchangam = DailyPanchangamHelper
				.getCurrentPanchangamByTime("18-05-2011", null, null);
		Gson gson = new GsonBuilder().setDateFormat("H:mm").setPrettyPrinting()
				.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
					@Override
					public JsonElement serialize(Date arg0, Type arg1,
							JsonSerializationContext arg2) {
						DateFormat format = new SimpleDateFormat("H:mm");
						format.setTimeZone(Constants.IST);
						return new JsonPrimitive(format.format(arg0));
					}
				}).excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(panchangam);
	}

}
