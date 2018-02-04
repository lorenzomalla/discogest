package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.ProdottiDao;
import it.discogest.model.Prodotti;

@Service
public class ProdottiServiceImpl implements ProdottiService {
	
	@Autowired
	private ProdottiDao dao;

	@Override
	public void add(Prodotti prodotti) {
		dao.add(prodotti);
	}
	
	

}
