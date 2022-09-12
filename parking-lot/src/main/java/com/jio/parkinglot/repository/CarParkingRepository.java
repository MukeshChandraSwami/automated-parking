package com.jio.parkinglot.repository;

import com.jio.parkinglot.constants.ParkingStatus;
import com.jio.parkinglot.entity.ParkingEntity;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarParkingRepository extends MongoRepository<ParkingEntity, String> {

    @Query(value = "{'status' : ?0}", count = true)
    long countSlots(ParkingStatus status);

    @Query(value = "{'RESERVED' : ?0}")
    List<ParkingEntity> findParking(boolean reservable);
}
