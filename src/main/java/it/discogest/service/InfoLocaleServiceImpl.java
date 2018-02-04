package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.InfoLocaleDao;
import it.discogest.model.InfoLocale;

@Service
public class InfoLocaleServiceImpl implements InfoLocaleService{

	@Autowired
	private InfoLocaleDao dao;
	
	@Override
	public void add(InfoLocale infoLocale) {
		dao.add(infoLocale);
	}

}
