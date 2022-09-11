package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class ResourceNotFoundException extends Exception implements Supplier<ResourceNotFoundException> {

    private ResponseCode errorResponse;

    public ResourceNotFoundException(ResponseCode errorResponse) {
        super(errorResponse.getResponseMassage());
        this.errorResponse = errorResponse;
    }

    @Override
    public ResourceNotFoundException get() {
        return this;
    }
}
