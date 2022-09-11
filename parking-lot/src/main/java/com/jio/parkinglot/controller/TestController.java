package com.jio.parkinglot.controller;

import com.jio.parkinglot.constants.ResponseCode;
import com.jio.parkinglot.response.shared.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test")
public class TestController {

    @GetMapping("/connectivity")
    public ResponseEntity<Response> tester() {
        return new ResponseEntity<>(new Response( ResponseCode.CONNECTIVITY_SUCCESS), HttpStatus.OK);
    }
}
