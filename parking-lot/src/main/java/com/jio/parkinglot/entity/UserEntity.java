package com.jio.parkinglot.entity;

import com.jio.parkinglot.constants.PhysicalCondition;
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
@Document("USER_DETAILS")
@Data
@Getter
@Builder
public class UserEntity implements Serializable,Cloneable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String userId;

    @NonNull
    @Field("FIRST_NAME")
    private String firstName;
    @NonNull
    @Field("LAST_NAME")
    private String lastName;
    @NonNull
    @Field("PHYSICAL_CONDITION")
    private PhysicalCondition physicalCondition;
    @NonNull
    @Field("MOBILE_NUMBER")
    private String mobileNumber;
    @NonNull
    @Field("EMAIL")
    private String email;
    @CreatedDate
    @Field("CREATED_AT")
    private Date createdAt;
    @LastModifiedDate
    @Field("UPDATED_AT")
    private Date updatedAt;

    @Override
    public UserEntity clone() {
        try {
            return (UserEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
