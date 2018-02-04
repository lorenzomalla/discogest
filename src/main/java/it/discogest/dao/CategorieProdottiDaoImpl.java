package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CategorieProdottiDaoImpl implements CategorieProdottiDao{

	private static final Logger logger = LoggerFactory.getLogger(CategorieProdottiDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
}
