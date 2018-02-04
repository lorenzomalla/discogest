package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.PrenotazioniDao;
import it.discogest.model.Prenotazioni;

@Service
public class PrenotazioniServiceImpl implements PrenotazioniService{

	@Autowired
	private PrenotazioniDao dao;
	
	@Override
	public void add(Prenotazioni prenotazioni) {
		dao.add(prenotazioni);
	}

}
