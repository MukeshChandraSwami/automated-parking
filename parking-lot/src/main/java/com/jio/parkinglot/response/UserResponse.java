package com.jio.parkinglot.response;

import com.jio.parkinglot.constants.ResponseCode;
import com.jio.parkinglot.response.model.User;
import com.jio.parkinglot.response.shared.Response;
import lombok.Getter;

@Getter
public class UserResponse extends Response {

    private User userDetails;
    public UserResponse(ResponseCode response, User userDetails) {
        super(response);
        this.userDetails = userDetails;
    }
}
