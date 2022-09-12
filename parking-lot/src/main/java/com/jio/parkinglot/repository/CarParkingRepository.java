package com.jio.parkinglot.repository;

import com.jio.parkinglot.constants.ParkingStatus;
import com.jio.parkinglot.entity.ParkingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarParkingRepository extends MongoRepository<ParkingEntity, String> {

    @Query(value = "{'status' : ?0}", count = true)
    long countSlots(ParkingStatus status);

}
