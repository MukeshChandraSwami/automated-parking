package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;

public class ParkingNotFoundException extends ResourceNotFoundException{

    public ParkingNotFoundException(ResponseCode errorResponse) {
        super(errorResponse);
    }
}
