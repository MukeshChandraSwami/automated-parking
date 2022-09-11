package com.jio.parkinglot.controller;

import com.jio.parkinglot.UserRequest;
import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.exceptions.ResourceNotFoundException;
import com.jio.parkinglot.response.shared.Response;
import com.jio.parkinglot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Response> getUserById(@PathVariable(value="id") String userId) throws ResourceNotFoundException {
        Response response = userService.getUserById(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Response> createUser(@Valid @RequestBody UserRequest request) throws ResourceCreationFailedException {
        Response response = userService.createUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/count")
    public ResponseEntity<Response> countRegisterUser() {
        Response response = userService.countRegisteredUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
