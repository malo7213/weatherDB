package de.malosoft.weather.svc;

import java.util.Date;
import java.util.List;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@ExecuteOn(TaskExecutors.IO)
@Controller("/weather")
public class WeatherController {

	protected final WeatherRepository weatherRepository;

    public WeatherController(WeatherRepository weatherRepository) { 
        this.weatherRepository = weatherRepository;
    }

	@Get("/")
	@Produces("text/plain")
    public String index() {
        return "ServiceWeather is started";
    }


	@Get("/allValues")
	public List<WeatherEntry> getAllValues() {
		return weatherRepository.findAll();
	}

	@Get("/allValues/{sender}")
	public List<WeatherEntry> getAllValues(@PathVariable String sender) {
		return weatherRepository.findAll(sender);
	}
	
	@Get("/getLastValues/{numEntries}")
	public List<WeatherEntry> getLastValues(@QueryValue Long numEntries) {
		return weatherRepository.getLastValues(numEntries);
	}

	@Post("/newData")
	public HttpStatus newData(@Body WeatherDAO newEntry) {
		
		WeatherEntry we = new WeatherEntry(new Date().getTime(), newEntry);
		weatherRepository.save(we);
		return HttpStatus.CREATED;
	}

}

