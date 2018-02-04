package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.SerateDao;
import it.discogest.model.Serate;

@Service
public class SerateServiceImpl implements SerateService{

	@Autowired
	private SerateDao dao;
	
	@Override
	public void add(Serate serate) {
		dao.add(serate);
	}

}
