package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.InfoUserDao;
import it.discogest.model.InfoUser;

@Service
public class InfoUserServiceImpl implements InfoUserService{

	@Autowired
	private InfoUserDao dao;

	@Override
	public void add(InfoUser infoUser) {
		dao.add(infoUser);
	}
	

	
}
