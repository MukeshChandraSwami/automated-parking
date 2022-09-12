package com.jio.parkinglot.operation.fun.parking;

import com.jio.parkinglot.entity.ParkingReservationEntity;
import com.jio.parkinglot.response.model.Parking;
import com.jio.parkinglot.response.model.ParkingReservationTicket;
import com.jio.parkinglot.response.model.User;
import com.jio.parkinglot.util.DateUtils;
import org.springframework.data.util.Pair;

import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.jio.parkinglot.constants.ReservationTicketStatus.PENDING;
import static com.jio.parkinglot.operation.sup.IDSupplier.ID_SUPPLIER;
import static com.jio.parkinglot.operation.sup.IDSupplier.RANDOM_NUMBER_SUPPLIER;

public interface ParkingReservationFunction {

    BiFunction<Integer, Integer, Date> PARKING_TICKET_TTL_CALCULATOR = (available, total) -> {
        int ttlMins = (total - available) >= available ? 15 : 30;
        return DateUtils.addMinutesInCurrentTime(ttlMins);
    };

    BiFunction<Pair<Parking, User>,Pair<Integer, Integer>,ParkingReservationEntity> GENERATE_PARKING_RESERVATION_TICKET =
            (pair,parkingStatistics) -> ParkingReservationEntity
                    .builder()
                    .parkingReservationId(ID_SUPPLIER.get())
                    .email(pair.getSecond().getEmail())
                    .parkingId(pair.getFirst().getParkingId())
                    .ticketNumber(RANDOM_NUMBER_SUPPLIER.get())
                    .status(PENDING)
                    .ttl(PARKING_TICKET_TTL_CALCULATOR.apply(parkingStatistics.getFirst(), parkingStatistics.getSecond()))
                    .createdAt(new Date())
                    .updatedAt(new Date())
                    .build();

    Function<ParkingReservationEntity,ParkingReservationTicket> PARKING_RESERVATION_ENTITY_TO_PARKING_RESERVATION_TICKET =
            (entity) -> ParkingReservationTicket.builder()
                    .parkingReservationId(entity.getParkingReservationId())
                    .ticketNumber(entity.getTicketNumber())
                    .email(entity.getEmail())
                    .ttl(entity.getTtl())
                    .createdAt(entity.getCreatedAt())
                    .status(entity.getStatus())
                    .build();
}
