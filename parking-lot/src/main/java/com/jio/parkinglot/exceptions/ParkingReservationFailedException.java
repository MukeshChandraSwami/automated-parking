package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;

public class ParkingReservationFailedException extends ParkingException{

    public ParkingReservationFailedException(ResponseCode errorResponse) {
        super(errorResponse);
    }
}
