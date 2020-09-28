package com.test.tracker.repository;

import com.test.tracker.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query(value = "SELECT *,(3959 *acos(cos(radians(?1) * cos(radians(lat)) * cos(radians(lon) - radians(?2)) + sin(radians(?1)) * sin(radians(lat ))))) AS distance FROM driver where status='AVAILABLE' ORDER BY distance desc LIMIT 1", nativeQuery = true)
    Driver getDriver(Double lat, Double lon);
}


/*
*
* SELECT a.city AS from_city, b.city AS to_city,
   111.111 *
    DEGREES(ACOS(LEAST(1.0, COS(RADIANS(a.Latitude))
         * COS(RADIANS(b.Latitude))
         * COS(RADIANS(a.Longitude - b.Longitude))
         + SIN(RADIANS(a.Latitude))
         * SIN(RADIANS(b.Latitude))))) AS distance_in_km
  FROM city AS a
  JOIN city AS b ON a.id <> b.id
 WHERE a.city = 3 AND b.city = 7
* */