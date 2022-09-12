package com.jio.parkinglot.entity;

import com.jio.parkinglot.constants.ParkingStatus;
import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Document("PARKING_SLOTS")
@Data
@Getter
@Builder
public class ParkingEntity implements Serializable,Cloneable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String parkingId;

    private int tracker;
    @NonNull
    @Field("IDENTIFIER")
    private String parkingIdentifier;
    @CreatedDate
    @Field("CREATED_AT")
    private Date createdAt;
    @LastModifiedDate
    @Field("UPDATED_AT")
    private Date updatedAt;
    @Field("RESERVED")
    private boolean reservable;
    @Field("STATUS")
    private ParkingStatus status;

    @Override
    public ParkingEntity clone() {
        try {
            return  (ParkingEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
