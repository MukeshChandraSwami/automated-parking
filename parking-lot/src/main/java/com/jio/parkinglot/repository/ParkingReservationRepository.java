package com.jio.parkinglot.repository;

import com.jio.parkinglot.constants.ReservationTicketStatus;
import com.jio.parkinglot.entity.ParkingReservationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ParkingReservationRepository extends MongoRepository<ParkingReservationEntity, String> {

    @Query(value = "{'EMAIL' : ?0, 'STATUS' : ?1, 'TTL' : { $gt: ?2 } }")
    ParkingReservationEntity checkIfTicketExists(String email, ReservationTicketStatus status, Date date);
}
