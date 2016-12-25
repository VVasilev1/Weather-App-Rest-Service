package bg.ittalents.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.ittalents.model.WeatherDAO;
import bg.ittalents.model.WeatherData;


@WebServlet("/")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("./weather.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		WeatherData data = new WeatherDAO().getWeatherData(city, country);
		request.setAttribute("data", data);
		request.getRequestDispatcher("./weather.jsp").forward(request, response);
	}

}
