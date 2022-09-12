package com.jio.parkinglot.service.parking;

import com.jio.parkinglot.entity.ParkingReservationEntity;
import com.jio.parkinglot.exceptions.ParkingException;
import com.jio.parkinglot.exceptions.ParkingFullException;
import com.jio.parkinglot.exceptions.ParkingReservationFailedException;
import com.jio.parkinglot.exceptions.ResourceNotFoundException;
import com.jio.parkinglot.repository.ParkingReservationRepository;
import com.jio.parkinglot.response.ParkingReservationResponse;
import com.jio.parkinglot.response.ParkingResponse;
import com.jio.parkinglot.response.ResourceCountResponse;
import com.jio.parkinglot.response.UserResponse;
import com.jio.parkinglot.response.model.Parking;
import com.jio.parkinglot.response.model.ParkingReservationTicket;
import com.jio.parkinglot.response.shared.Response;
import com.jio.parkinglot.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import static com.jio.parkinglot.constants.ParkingStatus.BLOCKED;
import static com.jio.parkinglot.constants.ReservationTicketStatus.PENDING;
import static com.jio.parkinglot.constants.ResponseCode.*;
import static com.jio.parkinglot.operation.fun.ResponseChecker.RESPONSE_CHECKER;
import static com.jio.parkinglot.operation.fun.parking.ParkingReservationFunction.GENERATE_PARKING_RESERVATION_TICKET;
import static com.jio.parkinglot.operation.fun.parking.ParkingReservationFunction.PARKING_RESERVATION_ENTITY_TO_PARKING_RESERVATION_TICKET;
import static com.jio.parkinglot.operation.fun.user.UserFunctions.PHYSICALLY_CHALLENGED;

@Service("carParkingReservationService")
public class CarParkingReservationService implements ReserveParkingService {

    private final Logger LOG = LoggerFactory.getLogger(CarParkingReservationService.class);

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("carParkingService")
    private ParkingService parkingService;

    @Value("${parking.total.slots}")
    private int maxParkingSize;

    @Autowired
    private ParkingReservationRepository parkingReservationRepository;

    @Override
    public Response reserveParking(String email) throws ResourceNotFoundException, ParkingException {

        // If parking already reserved then return same ticket.
        Optional<ParkingReservationEntity> existingTicket = Optional.ofNullable(parkingReservationRepository.checkIfTicketExists(email, PENDING, new Date()));
        if(existingTicket.isPresent()) {
            return new ParkingReservationResponse(SUCCESS ,PARKING_RESERVATION_ENTITY_TO_PARKING_RESERVATION_TICKET.apply(existingTicket.get()));
        }


        // If parking is full then returned from here
        int totalAvailableSlots = getTotalAvailableSlots();
        if(totalAvailableSlots == 0) {
            throw  new ParkingFullException(PARKING_FULL);
        }

        // Check if user is exists.
        UserResponse userResponse = (UserResponse) userService.getUserByEmail(email);

        // If physical conditions apply then reserve near by lift
        Parking parking = null;
        if(RESPONSE_CHECKER.apply(userResponse) && PHYSICALLY_CHALLENGED.apply(userResponse.getUserDetails())) {
            try {
                parking = getAvailableParkingSlot(true);
            }catch (ResourceNotFoundException e) {
                LOG.warn("Reserved parking is not available for : {}", email);
            }
        }

        // Otherwise reserve any available parking
        if(Objects.isNull(parking)) {
            parking = getAvailableParkingSlot(false);
        }


        // Create a ticket for parking reservation
        Optional<ParkingReservationEntity> parkingTicket = Optional.of(parkingReservationRepository.save(
                GENERATE_PARKING_RESERVATION_TICKET.apply(Pair.of(parking, userResponse.getUserDetails()),
                        Pair.of(totalAvailableSlots, maxParkingSize)))
        );

        // Update status of parking slot as blocked
        parking.setStatus(BLOCKED);
        parkingService.updateParking(parking);

        ParkingReservationTicket ticket = parkingTicket.map(PARKING_RESERVATION_ENTITY_TO_PARKING_RESERVATION_TICKET).orElseThrow(new ParkingReservationFailedException(PARKING_RESERVATION_FAILED));
        ticket.setParkingIdentifier(parking.getParkingIdentifier());

        return new ParkingReservationResponse(SUCCESS, ticket);
    }

    private Integer getTotalAvailableSlots() {
        ResourceCountResponse response = (ResourceCountResponse)parkingService.countAvailableParkingSlots();
        return (int)response.getCount();
    }

    private Parking getAvailableParkingSlot(boolean reservable) throws ResourceNotFoundException {
        Parking parking = null;
        ParkingResponse parkingResponse = (ParkingResponse) parkingService.getAvailableParking(reservable);
        if(RESPONSE_CHECKER.apply(parkingResponse)) {
            parking = parkingResponse.getParking();
        }
        return parking;
    }
}
