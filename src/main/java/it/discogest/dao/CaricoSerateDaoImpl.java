package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.discogest.model.CaricoSerate;
@Repository
public class CaricoSerateDaoImpl implements CaricoSerateDao{

	private static final Logger logger = LoggerFactory.getLogger(CaricoSerateDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(CaricoSerate carico) {
		em.persist(carico);
	}
	

}
