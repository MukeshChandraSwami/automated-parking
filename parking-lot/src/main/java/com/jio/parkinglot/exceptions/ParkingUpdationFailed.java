package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;

public class ParkingUpdationFailed extends ParkingException {

    public ParkingUpdationFailed(ResponseCode errorResponse) {
        super(errorResponse);
    }
}
