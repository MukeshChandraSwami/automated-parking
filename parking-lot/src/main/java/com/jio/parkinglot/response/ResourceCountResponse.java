package com.jio.parkinglot.response;

import com.jio.parkinglot.constants.ResponseCode;
import com.jio.parkinglot.response.shared.Response;
import lombok.Getter;

@Getter
public class ResourceCountResponse extends Response {

    private long count;

    public ResourceCountResponse(ResponseCode response, long count) {
        super(response);
        this.count = count;
    }
}
