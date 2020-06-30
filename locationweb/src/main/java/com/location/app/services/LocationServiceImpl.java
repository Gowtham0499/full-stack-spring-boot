package com.location.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.app.entities.Location;
import com.location.app.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location saveLocation(Location location) {
		return getLocationRepository().save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return getLocationRepository().save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		getLocationRepository().delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return getLocationRepository().findById(id).get();
	}

	@Override
	public List<Location> getAllLocations() {
		return getLocationRepository().findAll();
	}

	public LocationRepository getLocationRepository() {
		return locationRepository;
	}

	public void setLocationRepository(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

}
