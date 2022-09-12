package com.jio.parkinglot.service.parking;

import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.response.shared.Response;
import org.springframework.stereotype.Service;

@Service("bikeParkingService")
public class BikeParkingService implements ParkingService{

    @Override
    public Response createParking() throws ResourceCreationFailedException {
        return null;
    }

    @Override
    public Response countTotalParkingSlots() {
        return null;
    }

    @Override
    public Response countAvailableParkingSlots() {
        return null;
    }

    @Override
    public Response countOccupiedParkingSlots() {
        return null;
    }
}
