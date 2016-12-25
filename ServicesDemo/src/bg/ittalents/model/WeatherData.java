package bg.ittalents.model;

public class WeatherData {
	 private float temp;
	 private String description;
	 private int humidity;
	 private float windSpeed;
	 private String iconURL;
	 private String city;
	   	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "WeatherData [temp=" + temp + ", description=" + description + ", humidity=" + humidity + ", windSpeed="
				+ windSpeed + ", iconURL=" + iconURL + "]";
	}
	public String getIconURL() {
		return iconURL;
	}
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(double d) {
		this.temp = (float) d;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public float getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}
	 
	 
	 
}
