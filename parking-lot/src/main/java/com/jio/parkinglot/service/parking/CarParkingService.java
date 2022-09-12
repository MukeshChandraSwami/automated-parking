package com.jio.parkinglot.service.parking;

import com.jio.parkinglot.constants.ParkingStatus;
import com.jio.parkinglot.constants.ResponseCode;
import com.jio.parkinglot.entity.ParkingEntity;
import com.jio.parkinglot.exceptions.ParkingCreationFailedException;
import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.repository.CarParkingRepository;
import com.jio.parkinglot.response.ParkingCreationResponse;
import com.jio.parkinglot.response.ResourceCountResponse;
import com.jio.parkinglot.response.model.Parking;
import com.jio.parkinglot.response.shared.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.jio.parkinglot.constants.ParkingStatus.*;
import static com.jio.parkinglot.constants.ResponseCode.*;
import static com.jio.parkinglot.operation.fun.parking.ParkingFunction.PARKING_ENTITY_LIST_TO_PARKING_LIST;
import static com.jio.parkinglot.operation.fun.parking.ParkingFunction.PARKING_GENERATOR;

@Service("carParkingService")
public class CarParkingService implements ParkingService {

    @Autowired
    private CarParkingRepository parkingRepository;

    @Value("${parking.total.slots}")
    private int maxParkingSize;

    @Value("${parking.reserved.slots.percentage}")
    private int reservedPercentage;

    @Override
    public Response createParking() throws ResourceCreationFailedException {
        Response response = countTotalParkingSlots();
        if(response.getResponseCode().equalsIgnoreCase(SUCCESS.getResponseCode())) {
            ResourceCountResponse countResponse = (ResourceCountResponse) response;
            long carParkingCount = countResponse.getCount();
            if(carParkingCount >= maxParkingSize) {
                throw new ParkingCreationFailedException(PARKING_CREATION_FAILED_NO_MORE_SPACE);
            }
        }

        int reservableParkingCount = (maxParkingSize * reservedPercentage) / 100;
        List<ParkingEntity> parking = new ArrayList<>();
        for(int i = 1; i <= maxParkingSize; i++) {
            boolean reservable = i <= reservableParkingCount;
            parking.add(PARKING_GENERATOR.apply(i, reservable));
        }

        Optional<List<ParkingEntity>> parkingOp = Optional.of(parkingRepository.saveAll(parking));
        List<Parking> parkings = parkingOp.map(PARKING_ENTITY_LIST_TO_PARKING_LIST)
                .orElseThrow(new ParkingCreationFailedException(PARKING_CREATION_FAILED));

        return new ParkingCreationResponse(SUCCESS, parkings);
    }

    @Override
    public Response countTotalParkingSlots() {
        long count = parkingRepository.count();
        return new ResourceCountResponse(ResponseCode.SUCCESS, count);
    }

    @Override
    public Response countAvailableParkingSlots() {
        long count = parkingRepository.countSlots(AVAILABLE);
        return new ResourceCountResponse(ResponseCode.SUCCESS, count);
    }

    @Override
    public Response countOccupiedParkingSlots() {
        long count = parkingRepository.countSlots(OCCUPIED) + parkingRepository.countSlots(BLOCKED);
        return new ResourceCountResponse(ResponseCode.SUCCESS, count);
    }
}
