package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class ResourceCreationFailedException extends Exception implements Supplier<ResourceCreationFailedException> {

    private ResponseCode errorResponse;

    public ResourceCreationFailedException(ResponseCode errorResponse) {
        super(errorResponse.getResponseMassage());
        this.errorResponse = errorResponse;
    }

    @Override
    public ResourceCreationFailedException get() {
        return this;
    }
}
