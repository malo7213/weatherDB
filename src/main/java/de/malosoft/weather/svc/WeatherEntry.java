package de.malosoft.weather.svc;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weathercontrol")
public class WeatherEntry {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
	private Long timestamp;

	@Column(precision=10, scale=1, nullable=false)
	private BigDecimal humidity;

	@Column(precision=10, scale=1, nullable=false)
	private BigDecimal temperature;

	public WeatherEntry() {}
	
	public WeatherEntry(Long timestamp, BigDecimal humidity, BigDecimal temperature) {
		this.timestamp = timestamp;
		this.humidity = humidity;
		this.temperature = temperature;
	}
	
	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String toString() {
		return this.timestamp + "|" + this.humidity+ "|" + this.temperature;
	}
}
