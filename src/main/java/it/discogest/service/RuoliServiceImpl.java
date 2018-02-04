package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.RuoliDao;

@Service
public class RuoliServiceImpl implements RuoliService{

	@Autowired
	private RuoliDao dao;
	
}
