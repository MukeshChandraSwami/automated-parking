package com.jio.parkinglot.response.model;

import com.jio.parkinglot.constants.ParkingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Parking {

    private String parkingId;
    private String parkingIdentifier;
    private boolean reservable;
    private ParkingStatus status;
}
