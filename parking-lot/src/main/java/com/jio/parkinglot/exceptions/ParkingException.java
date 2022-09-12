package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class ParkingException extends Exception implements Supplier<ParkingException> {

    private ResponseCode errorResponse;

    public ParkingException(ResponseCode errorResponse) {
        super(errorResponse.getResponseMassage());
        this.errorResponse = errorResponse;
    }

    @Override
    public ParkingException get() {
        return this;
    }
}
