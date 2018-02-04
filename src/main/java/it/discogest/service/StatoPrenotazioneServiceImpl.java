package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.StatoPrenotazioneDao;

@Service
public class StatoPrenotazioneServiceImpl implements StatoPrenotazioneService{

	@Autowired
	private StatoPrenotazioneDao dao;
	
}
