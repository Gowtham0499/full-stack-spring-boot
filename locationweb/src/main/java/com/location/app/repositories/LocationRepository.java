package com.location.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.location.app.entities.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
