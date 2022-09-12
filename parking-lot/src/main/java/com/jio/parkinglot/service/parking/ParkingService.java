package com.jio.parkinglot.service.parking;

import com.jio.parkinglot.constants.ParkingStatus;
import com.jio.parkinglot.exceptions.ParkingException;
import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.exceptions.ResourceNotFoundException;
import com.jio.parkinglot.response.model.Parking;
import com.jio.parkinglot.response.shared.Response;
import org.springframework.stereotype.Service;

@Service
public interface ParkingService {

    Response createParking() throws ResourceCreationFailedException;

    Response countTotalParkingSlots();

    Response countAvailableParkingSlots();

    Response countOccupiedParkingSlots();

    Response getAvailableParking(boolean reservable) throws ResourceNotFoundException;

    Response updateParking(Parking parking) throws ParkingException;
}
