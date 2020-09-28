package com.test.tracker.repository;

import com.test.tracker.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query(value = "SELECT *, (3959 *acos(cos(radians(?1)) *cos(radians(lat)) * cos(radians(lon) - radians(?2)) + sin(radians(?1)) * sin(radians(lat)))) AS distance FROM driver where status='AVAILABLE' ORDER BY distance LIMIT 1", nativeQuery = true)
    Driver getDriver(Double lat, Double lon);
}