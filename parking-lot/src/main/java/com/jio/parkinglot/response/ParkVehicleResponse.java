package com.jio.parkinglot.response;

import com.jio.parkinglot.response.shared.BaseResponse;

public class ParkVehicleResponse extends BaseResponse {

    public ParkVehicleResponse(boolean success, String responseMassage, String responseCode) {
        super(success, responseMassage, responseCode);
    }

}
