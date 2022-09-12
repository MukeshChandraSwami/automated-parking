package com.jio.parkinglot.response.model;

import com.jio.parkinglot.constants.ParkingStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Parking {

    private String parkingId;
    private String parkingIdentifier;
    private boolean reservable;
    @Setter
    private ParkingStatus status;
    private Date creationTime;
}
