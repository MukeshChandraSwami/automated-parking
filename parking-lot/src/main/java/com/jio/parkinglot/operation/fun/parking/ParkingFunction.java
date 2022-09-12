package com.jio.parkinglot.operation.fun.parking;

import com.jio.parkinglot.entity.ParkingEntity;
import com.jio.parkinglot.response.model.Parking;

import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.jio.parkinglot.constants.ParkingStatus.AVAILABLE;
import static com.jio.parkinglot.operation.sup.IDSupplier.ID_SUPPLIER;

public interface ParkingFunction {

    BiFunction<Integer, Boolean, ParkingEntity> PARKING_GENERATOR = (i,reservable) -> ParkingEntity.builder()
            .createdAt(new Date())
            .updatedAt(new Date())
            .parkingId(ID_SUPPLIER.get())
            .reservable(reservable)
            .tracker(i)
            .status(AVAILABLE)
            .parkingIdentifier("P-"+i)
            .build();

    Function<ParkingEntity, Parking> PARKING_ENTITY_TO_PARKING = parkingEntity -> Parking.builder()
            .parkingId(parkingEntity.getParkingId())
            .parkingIdentifier(parkingEntity.getParkingIdentifier())
            .status(parkingEntity.getStatus())
            .reservable(parkingEntity.isReservable())
            .build();


    Function<List<ParkingEntity>, List<Parking>> PARKING_ENTITY_LIST_TO_PARKING_LIST =
            parkingEntities -> parkingEntities
                    .stream()
                    .map(PARKING_ENTITY_TO_PARKING)
                    .toList();
}
