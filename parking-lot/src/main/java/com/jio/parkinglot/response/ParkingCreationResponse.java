package com.jio.parkinglot.response;

import com.jio.parkinglot.constants.ResponseCode;
import com.jio.parkinglot.response.model.Parking;
import com.jio.parkinglot.response.shared.Response;
import lombok.Getter;

import java.util.List;

@Getter
public class ParkingCreationResponse extends Response {

    private List<Parking> parkings;
    public ParkingCreationResponse(ResponseCode responseCode, List<Parking> parkings) {
        super(responseCode);
        this.parkings = parkings;
    }
}
