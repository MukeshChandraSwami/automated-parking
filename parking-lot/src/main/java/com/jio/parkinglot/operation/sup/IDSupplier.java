package com.jio.parkinglot.operation.sup;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public interface IDSupplier {
    Supplier<String> ID_SUPPLIER = () -> UUID.randomUUID() + "-" + new Date().getTime();

    Supplier<String> RANDOM_NUMBER_SUPPLIER = () -> {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    };
}
