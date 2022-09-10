package com.jio.parkinglot.response;

import com.jio.parkinglot.response.shared.BaseResponse;

public class ParkingResponse extends BaseResponse {

    public ParkingResponse(boolean success, String responseMassage, String responseCode) {
        super(success, responseMassage, responseCode);
    }
}
