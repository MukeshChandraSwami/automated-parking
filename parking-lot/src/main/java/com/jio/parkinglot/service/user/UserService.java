package com.jio.parkinglot.service.user;

import com.jio.parkinglot.UserRequest;
import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.exceptions.ResourceNotFoundException;
import com.jio.parkinglot.response.shared.Response;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Response getUserById(String userId) throws ResourceNotFoundException;

    Response createUser(UserRequest request) throws ResourceCreationFailedException;

    Response countRegisteredUsers();
}
