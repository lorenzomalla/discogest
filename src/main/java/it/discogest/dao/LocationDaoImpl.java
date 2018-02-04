package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.discogest.model.Location;
@Repository
public class LocationDaoImpl implements LocationDao{

	private static final Logger logger = LoggerFactory.getLogger(LocationDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Location location) {
		em.persist(location);
	}

}
