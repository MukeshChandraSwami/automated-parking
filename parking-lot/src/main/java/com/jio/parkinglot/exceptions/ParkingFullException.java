package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;

public class ParkingFullException extends ParkingException {

    public ParkingFullException(ResponseCode errorResponse) {
        super(errorResponse);
    }
}
