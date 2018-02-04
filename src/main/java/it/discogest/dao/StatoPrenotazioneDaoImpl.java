package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StatoPrenotazioneDaoImpl implements StatoPrenotazioneDao{

	private static final Logger logger = LoggerFactory.getLogger(StatoPrenotazioneDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
}
