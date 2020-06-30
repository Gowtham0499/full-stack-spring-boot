package com.location.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.app.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
