package de.malosoft.weather.svc;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "weathercontrol")
@NamedQuery(name="WeatherEntry.getAllValuesForSender", query="select w from WeatherEntry w where w.sender = ?1")
public class WeatherEntry {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
	private String sender;

	@Column(nullable = false)
	private Long timestamp;

	@Column(precision=10, scale=1, nullable=false)
	private BigDecimal humidity;

	@Column(precision=10, scale=1, nullable=false)
	private BigDecimal temperature;

	public WeatherEntry() {}

	public WeatherEntry(long time, WeatherDAO newEntry) {
		this.timestamp = time;
		this.sender = newEntry.getSender().replaceAll(":", "");
		this.temperature = newEntry.getTemperature();
		this.humidity = newEntry.getHumidity();
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

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String toString() {
		return this.sender + "|" + this.timestamp + "|" + this.humidity+ "|" + this.temperature;
	}
}
