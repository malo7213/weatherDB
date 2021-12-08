package de.malosoft.weather.svc;

import java.math.BigDecimal;

public class WeatherDAO {

	private String sender;
	private BigDecimal humidity;
	private BigDecimal temperature;

	public WeatherDAO() {}
	
	public WeatherDAO(String sender, BigDecimal humidity, BigDecimal temperature) {
		this.sender = sender;
		this.humidity = humidity;
		this.temperature = temperature;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}
	
}
