package it.discogest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.discogest.model.Prodotti;
@Repository
public class ProdottiDaoImpl implements ProdottiDao{

	private static final Logger logger = LoggerFactory.getLogger(ProdottiDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Prodotti prodotti) {
		em.persist(prodotti);
	}

}
