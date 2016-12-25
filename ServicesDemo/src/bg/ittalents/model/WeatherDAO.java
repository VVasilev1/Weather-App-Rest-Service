 package bg.ittalents.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class WeatherDAO {
	private static final String ICON_EXTENSION = ".png";
	private static final String WEATHER_ICON_URL = "http://openweathermap.org/img/w/";
	private static final int HTTP_SUCCES = 200;
	private static final String API_KEY = "f631fd357c75163a46154773a513dd64";
	private static final String MAIN_URL = "http://api.openweathermap.org/data/2.5/weather";

	public WeatherData getWeatherData(String city, String country) {
		String url = MAIN_URL + "?q=" + city + "," + country + "&apikey=" + API_KEY;
		try {
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("GET");
			if (con.getResponseCode() == HTTP_SUCCES) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line = reader.readLine();
				StringBuilder builder = new StringBuilder();

				while (line != null) {
					builder.append(line);
					line = reader.readLine();
				}
				Gson gson = new Gson();
				JsonObject jsonObj = gson.fromJson(builder.toString(), JsonObject.class);
				WeatherData result = new WeatherData();
				result.setHumidity(jsonObj.getAsJsonObject("main").get("humidity").getAsInt());
				result.setWindSpeed(jsonObj.getAsJsonObject("wind").get("speed").getAsFloat());
				result.setDescription(
						jsonObj.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString());
				result.setTemp(jsonObj.getAsJsonObject("main").get("temp").getAsDouble()-273.15);
				
				result.setIconURL(WEATHER_ICON_URL
						+ jsonObj.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString()
						+ ICON_EXTENSION);
				result.setCity(jsonObj.get("name").getAsString());

				return result;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
