package com.jio.parkinglot.service.parking;

import com.jio.parkinglot.exceptions.ParkingException;
import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.exceptions.ResourceNotFoundException;
import com.jio.parkinglot.response.model.Parking;
import com.jio.parkinglot.response.shared.Response;
import org.springframework.stereotype.Service;

@Service("bikeParkingService")
public class BikeParkingService implements ParkingService {

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

    @Override
    public Response getAvailableParking(boolean reservable) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Response updateParking(Parking parking) throws ParkingException {
        return null;
    }
}
