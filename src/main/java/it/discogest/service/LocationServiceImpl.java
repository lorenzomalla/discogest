package it.discogest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.discogest.dao.LocationDao;
import it.discogest.model.Location;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDao dao;
	
	@Override
	public void add(Location location) {
		dao.add(location);
	}

	
}
