package com.jio.parkinglot.controller;

import com.jio.parkinglot.exceptions.ParkingException;
import com.jio.parkinglot.exceptions.ResourceNotFoundException;
import com.jio.parkinglot.response.shared.Response;
import com.jio.parkinglot.service.parking.ReserveParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking/v1")
public class ReserveCarParkingController {

    @Autowired
    @Qualifier("carParkingReservationService")
    private ReserveParkingService reserveParkingService;

    @PutMapping
    @RequestMapping("/{email}/reserve")
    public ResponseEntity<Response> reserveParking(@PathVariable(value="email") String email) throws ParkingException, ResourceNotFoundException {
        Response response = reserveParkingService.reserveParking(email);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
