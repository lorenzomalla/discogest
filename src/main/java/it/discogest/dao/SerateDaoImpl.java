package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.discogest.model.Serate;
@Repository
public class SerateDaoImpl implements SerateDao{

	private static final Logger logger = LoggerFactory.getLogger(SerateDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Serate serate) {
		em.persist(serate);
	}

}
