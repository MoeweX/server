package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		JSONObject obj = new JSONObject();
		
		try {
			obj.put("Daten", "keine");
			obj.put("Wissen", "weniger als Daten");
			obj.put("Schuldiger", "Langeweile");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		PrintWriter w = resp.getWriter();
		w.write(obj.toString());
	}
	
}
