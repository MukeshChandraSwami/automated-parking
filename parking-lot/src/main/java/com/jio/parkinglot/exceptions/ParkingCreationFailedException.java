package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;

public class ParkingCreationFailedException extends ResourceCreationFailedException {

    public ParkingCreationFailedException(ResponseCode errorResponse) {
        super(errorResponse);
    }
}
