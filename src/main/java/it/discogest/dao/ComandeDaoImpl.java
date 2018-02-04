package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.discogest.model.Comande;
@Repository
public class ComandeDaoImpl implements ComandeDao {

	private static final Logger logger = LoggerFactory.getLogger(ComandeDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Comande comande) {
		em.persist(comande);
	}

}
