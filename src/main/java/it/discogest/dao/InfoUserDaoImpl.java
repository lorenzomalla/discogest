package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.discogest.model.InfoUser;
@Repository
public class InfoUserDaoImpl implements InfoUserDao{

	private static final Logger logger = LoggerFactory.getLogger(InfoUserDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(InfoUser infoUser) {
		em.persist(infoUser);
	}

}
