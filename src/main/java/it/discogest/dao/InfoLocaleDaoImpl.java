package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.discogest.model.InfoLocale;
@Repository
public class InfoLocaleDaoImpl implements InfoLocaleDao{

	private static final Logger logger = LoggerFactory.getLogger(InfoLocaleDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(InfoLocale infoLocale) {
		em.persist(infoLocale);
	}

}
