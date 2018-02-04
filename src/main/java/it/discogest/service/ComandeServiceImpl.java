package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.ComandeDao;
import it.discogest.model.Comande;

@Service
public class ComandeServiceImpl implements ComandeService{

	@Autowired
	private ComandeDao dao;
	
	@Override
	public void add(Comande comande) {
		dao.add(comande);
	}

}
