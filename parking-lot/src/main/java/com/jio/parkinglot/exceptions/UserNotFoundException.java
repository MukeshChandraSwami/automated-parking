package com.jio.parkinglot.exceptions;

import com.jio.parkinglot.constants.ResponseCode;

public class UserNotFoundException extends ResourceNotFoundException {

    public UserNotFoundException(ResponseCode errorResponse) {
        super(errorResponse);
    }
}
