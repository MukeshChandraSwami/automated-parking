package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;

public class UserCreationFailedException extends ResourceCreationFailedException {


    public UserCreationFailedException(ResponseCode errorResponse) {
        super(errorResponse);
    }
}
