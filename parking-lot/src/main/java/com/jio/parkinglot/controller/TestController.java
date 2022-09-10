package com.jio.parkinglot.controller;

import com.jio.parkinglot.response.shared.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test")
public class TestController {

    @GetMapping("/connectivity")
    public ResponseEntity<BaseResponse> tester() {
        return new ResponseEntity<>(new BaseResponse(true, "Tested","200"), HttpStatus.OK);
    }
}
