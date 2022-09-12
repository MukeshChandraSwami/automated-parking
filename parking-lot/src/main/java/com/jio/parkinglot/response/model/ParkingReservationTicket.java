package com.jio.parkinglot.response.model;

import com.jio.parkinglot.constants.ReservationTicketStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Builder
public class ParkingReservationTicket {

    private String parkingReservationId;
    private String ticketNumber;
    private String parkingIdentifier;
    private String email;
    private Date ttl;
    private ReservationTicketStatus status;
    private Date createdAt;
}
