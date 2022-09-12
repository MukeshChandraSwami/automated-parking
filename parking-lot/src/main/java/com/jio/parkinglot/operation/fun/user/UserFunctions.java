package com.jio.parkinglot.operation.fun.user;

import com.jio.parkinglot.request.UserRequest;
import com.jio.parkinglot.entity.UserEntity;
import com.jio.parkinglot.response.model.User;

import java.util.Date;
import java.util.function.Function;

import static com.jio.parkinglot.operation.sup.IDSupplier.ID_SUPPLIER;

public interface UserFunctions {

    Function<UserEntity, User> USER_ENTITY_TO_USER = userEntity -> User
            .builder()
            .userId(userEntity.getUserId())
            .firstName(userEntity.getFirstName())
            .lastName(userEntity.getLastName())
            .email(userEntity.getEmail())
            .mobileNumber(userEntity.getMobileNumber())
            .physicalCondition(userEntity.getPhysicalCondition())
            .build();

    Function<UserRequest, UserEntity> USER_REQUEST_TO_USER_ENTITY = request ->  UserEntity
                .builder()
                .userId(ID_SUPPLIER.get())
                .physicalCondition(request.getPhysicalCondition())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .mobileNumber(request.getMobileNumber())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
}
