package de.malosoft.weather.svc;

import java.util.List;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
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
	
	@Post("/newData")
	public HttpStatus newData(@Body WeatherEntry newEntry) { 
		weatherRepository.save(newEntry);
		return HttpStatus.CREATED;
	}

}

