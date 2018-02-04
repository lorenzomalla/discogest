package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.CategorieProdottiDao;

@Service
public class CategorieProdottiServiceImpl implements CategorieProdottiService{

	@Autowired
	private CategorieProdottiDao dao;
	
	
}
