package com.jio.parkinglot.response.model;

import com.jio.parkinglot.constants.PhysicalCondition;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User implements Serializable,Cloneable{
    @Serial
    private static final long serialVersionUID = 1L;

    private String userId;
    private String firstName;
    private String lastName;
    private PhysicalCondition physicalCondition;
    private String mobileNumber;
    private String email;

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
