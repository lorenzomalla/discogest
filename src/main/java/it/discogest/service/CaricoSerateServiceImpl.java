package it.discogest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.CaricoSerateDao;
import it.discogest.model.CaricoSerate;
@Service
public class CaricoSerateServiceImpl implements CaricoSerateService{

	@Autowired
	private CaricoSerateDao dao;
	
	@Override
	public void add(CaricoSerate carico) {
		dao.add(carico);
	}
	

}
