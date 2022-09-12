package com.jio.parkinglot.response;

import com.jio.parkinglot.constants.ResponseCode;
import com.jio.parkinglot.response.model.Parking;
import com.jio.parkinglot.response.shared.Response;
import lombok.Getter;

@Getter
public class ParkingResponse extends Response {

    private Parking parking;

    public ParkingResponse(ResponseCode response, Parking parking) {
        super(response);
        this.parking = parking;
    }
}
