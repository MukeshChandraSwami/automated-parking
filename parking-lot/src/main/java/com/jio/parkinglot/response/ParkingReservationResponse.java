package com.jio.parkinglot.response;

import com.jio.parkinglot.constants.ResponseCode;
import com.jio.parkinglot.response.model.ParkingReservationTicket;
import com.jio.parkinglot.response.shared.Response;
import lombok.Getter;

@Getter
public class ParkingReservationResponse extends Response {

    private ParkingReservationTicket ticket;

    public ParkingReservationResponse(ResponseCode response, ParkingReservationTicket ticket) {
        super(response);
        this.ticket = ticket;
    }
}
