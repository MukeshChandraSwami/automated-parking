package com.jio.parkinglot.service.parking;

import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.response.shared.Response;
import org.springframework.stereotype.Service;

@Service
public interface ParkingService {

    Response createParking() throws ResourceCreationFailedException;

    Response countTotalParkingSlots();

    Response countAvailableParkingSlots();

    Response countOccupiedParkingSlots();
}
