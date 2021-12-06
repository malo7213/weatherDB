package de.malosoft.weather.svc;

import java.util.List;

import javax.persistence.EntityManager;

import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;

@Singleton
public class WeatherRepository {

	private final EntityManager entityManager;

	public WeatherRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@ReadOnly
	public List<WeatherEntry> findAll() {
		return entityManager.createQuery("select w from WeatherEntry w", WeatherEntry.class).getResultList();
	}

	@TransactionalAdvice
	public void save(WeatherEntry newEntry) {
		System.err.println(newEntry.toString());
		entityManager.persist(newEntry);
	}

}
