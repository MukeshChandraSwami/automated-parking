package com.jio.parkinglot.service.parking;

import com.jio.parkinglot.exceptions.ParkingException;
import com.jio.parkinglot.exceptions.ParkingFullException;
import com.jio.parkinglot.exceptions.ResourceNotFoundException;
import com.jio.parkinglot.response.shared.Response;
import org.springframework.stereotype.Service;

@Service
public interface ReserveParkingService {

    Response reserveParking(String email) throws ResourceNotFoundException, ParkingException;

    /*Response parkVehicle(String reservationNumber) throws ResourceNotFoundException, ParkingAlreadyOccupiedException;*/
}
