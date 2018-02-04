package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.discogest.model.Prenotazioni;
@Repository
public class PrenotazioniDaoImpl implements PrenotazioniDao{

	private static final Logger logger = LoggerFactory.getLogger(PrenotazioniDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Prenotazioni prenotazioni) {
		em.persist(prenotazioni);
	}

}
