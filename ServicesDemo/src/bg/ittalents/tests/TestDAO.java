package bg.ittalents.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import bg.ittalents.model.WeatherDAO;

public class TestDAO {

	@Test
	public void testDownloadJSON() {
		System.out.println(new WeatherDAO().getWeatherData("Sofia", "bg"));
		
	}

}
