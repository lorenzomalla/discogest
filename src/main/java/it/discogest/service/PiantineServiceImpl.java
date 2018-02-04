package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.PiantineDao;
import it.discogest.model.Piantine;

@Service
public class PiantineServiceImpl implements PiantineService{

	@Autowired
	private PiantineDao dao;
	
	@Override
	public void add(Piantine piantine) {
		dao.add(piantine);
	}

}
