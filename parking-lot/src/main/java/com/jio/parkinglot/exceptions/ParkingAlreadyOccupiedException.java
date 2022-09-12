package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;

public class ParkingAlreadyOccupiedException extends ParkingException {

    public ParkingAlreadyOccupiedException(ResponseCode errorResponse) {
        super(errorResponse);
    }
}
