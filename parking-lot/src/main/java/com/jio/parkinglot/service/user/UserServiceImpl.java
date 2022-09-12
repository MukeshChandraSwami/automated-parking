package com.jio.parkinglot.service.user;

import com.jio.parkinglot.request.UserRequest;
import com.jio.parkinglot.constants.ResponseCode;
import com.jio.parkinglot.entity.UserEntity;
import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.exceptions.ResourceNotFoundException;
import com.jio.parkinglot.exceptions.UserCreationFailedException;
import com.jio.parkinglot.exceptions.UserNotFoundException;
import com.jio.parkinglot.repository.UserRepository;
import com.jio.parkinglot.response.ResourceCountResponse;
import com.jio.parkinglot.response.UserResponse;
import com.jio.parkinglot.response.model.User;
import com.jio.parkinglot.response.shared.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.jio.parkinglot.constants.ResponseCode.USER_CREATION_FAILED;
import static com.jio.parkinglot.constants.ResponseCode.USER_NOT_FOUND;
import static com.jio.parkinglot.operation.fun.user.UserFunctions.USER_ENTITY_TO_USER;
import static com.jio.parkinglot.operation.fun.user.UserFunctions.USER_REQUEST_TO_USER_ENTITY;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public Response getUserById(String userId) throws ResourceNotFoundException {
        Optional<UserEntity> userOp = userRepository.findById(userId);
        User user = userOp.map(USER_ENTITY_TO_USER).orElseThrow(new UserNotFoundException(USER_NOT_FOUND));
        return new UserResponse(ResponseCode.SUCCESS,user);
    }

    @Override
    public Response createUser(UserRequest request) throws ResourceCreationFailedException {
        LOG.info("Creating User : {}", request);
        Optional<UserEntity> userOp = Optional.of(userRepository.save(USER_REQUEST_TO_USER_ENTITY.apply(request)));
        User user = userOp.map(USER_ENTITY_TO_USER).orElseThrow(new UserCreationFailedException(USER_CREATION_FAILED));
        return new UserResponse(ResponseCode.SUCCESS,user);
    }

    @Override
    public Response countRegisteredUsers() {
        long count = userRepository.count();
        return new ResourceCountResponse(ResponseCode.SUCCESS, count);
    }
}
