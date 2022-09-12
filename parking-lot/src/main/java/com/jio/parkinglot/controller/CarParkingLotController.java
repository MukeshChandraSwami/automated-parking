package com.jio.parkinglot.controller;

import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.response.shared.Response;
import com.jio.parkinglot.service.parking.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking/v1")
public class CarParkingLotController {

    @Autowired
    @Qualifier("carParkingService")
    private ParkingService parkingService;

    @PutMapping
    @RequestMapping("/create")
    public ResponseEntity<Response> createParkingSlots() throws ResourceCreationFailedException {
        Response response = parkingService.createParking();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/count/all")
    public ResponseEntity<Response> countTotalParkingSlots() throws ResourceCreationFailedException {
        Response response = parkingService.countTotalParkingSlots();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/count/available")
    public ResponseEntity<Response> countTotalAvailableParkingSlots() throws ResourceCreationFailedException {
        Response response = parkingService.countAvailableParkingSlots();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/count/occupied")
    public ResponseEntity<Response> countTotalOccupiedParkingSlots() throws ResourceCreationFailedException {
        Response response = parkingService.countOccupiedParkingSlots();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
