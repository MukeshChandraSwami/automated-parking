package com.jio.parkinglot.operation.sup;

import java.util.Date;
import java.util.UUID;
import java.util.function.Supplier;

public interface IDSupplier {
    Supplier<String> ID_SUPPLIER = () -> UUID.randomUUID() + "-" + new Date().getTime();
}
