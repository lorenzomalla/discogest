package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.discogest.model.Piantine;
@Repository
public class PiantineDaoImpl implements PiantineDao{

	private static final Logger logger = LoggerFactory.getLogger(PiantineDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Piantine piantine) {
		em.persist(piantine);
	}

}
