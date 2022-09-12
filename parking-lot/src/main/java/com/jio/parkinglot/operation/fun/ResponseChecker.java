package com.jio.parkinglot.operation.fun;

import com.jio.parkinglot.response.shared.Response;

import java.util.function.Function;

import static com.jio.parkinglot.constants.ResponseCode.SUCCESS;

public interface ResponseChecker {

    Function<Response, Boolean> RESPONSE_CHECKER = res -> res.getResponseCode().equalsIgnoreCase(SUCCESS.getResponseCode());
}
