package com.jio.parkinglot.entity;

import com.jio.parkinglot.constants.ReservationTicketStatus;
import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Document("PARKING_RESERVATION_TICKET")
@Data
@Getter
@Builder
public class ParkingReservationEntity {

    @Id
    private String parkingReservationId;
    @NonNull
    @Field("EMAIL")
    private String email;
    @NonNull
    @Field("TICKET_NUMBER")
    private String ticketNumber;
    @NonNull
    @Field("PARKING_ID")
    private String parkingId;
    @NonNull
    @Field("TTL")
    private Date ttl;
    @NonNull
    @Field("STATUS")
    private ReservationTicketStatus status;
    @Field("CREATED_AT")
    private Date createdAt;
    @NonNull
    @Field("UPDATED_AT")
    private Date updatedAt;
}
