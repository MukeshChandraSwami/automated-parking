package com.jio.parkinglot.request;

import com.jio.parkinglot.constants.PhysicalCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserRequest implements Serializable,Cloneable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private PhysicalCondition physicalCondition;
    @NotNull
    @Size(min=10, max = 10)
    private String mobileNumber;
    @Email
    private String email;

    @Override
    public UserRequest clone() {
        try {
            return (UserRequest)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
