package com.jio.parkinglot.response.shared;

import com.jio.parkinglot.constants.ResponseCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Response implements Serializable {

    private String responseCode;
    private String responseMassage;

    public Response(ResponseCode response) {
        this.responseCode = response.getResponseCode();
        this.responseMassage = response.getResponseMassage();
    }
}
