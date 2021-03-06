package de.malosoft.weather.svc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		return entityManager.createQuery("select w from WeatherEntry w order by id asc", WeatherEntry.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@ReadOnly
	public List<WeatherEntry> getLastValues(Long numEntries, String sender) {
		Query query = entityManager.createNamedQuery("WeatherEntry.getLastEntries");
		query.setParameter(1, numEntries);
		query.setParameter(2, sender);

		return (List<WeatherEntry>)query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@ReadOnly
	public List<WeatherEntry> findAll(String sender) {
		Query query = entityManager.createNamedQuery("WeatherEntry.getAllValuesForSender");
		query.setParameter(1, sender);

		List<WeatherEntry> list = (List<WeatherEntry>)query.getResultList();
		return list;
	}

	@TransactionalAdvice
	public void save(WeatherEntry newEntry) {
		System.err.println(newEntry.toString());
		entityManager.persist(newEntry);
	}

}
