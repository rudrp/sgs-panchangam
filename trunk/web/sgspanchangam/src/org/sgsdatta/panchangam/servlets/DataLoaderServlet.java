package org.sgsdatta.panchangam.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sgsdatta.panchangam.dao.PanchangamDAO;
import org.sgsdatta.panchangam.data.Panchangam;
import org.sgsdatta.panchangam.data.loader.PanchangamDataLoader;

import com.googlecode.objectify.Key;

public class DataLoaderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(DataLoaderServlet.class
			.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PanchangamDataLoader dataLoader = new PanchangamDataLoader();
		try {
			// PanchangamApplicationListener.class.getClassLoader().loadClass("/com/google/appengine/repackaged/org/joda/time/LocalTime");
			dataLoader.loadData();
			PanchangamDAO dao= new PanchangamDAO();
			Map<Key<Panchangam>, Panchangam> m =dao.getAllPanchangam();
			System.out.println(m.size());
			
			resp.getWriter().write("Data Loaded Successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
