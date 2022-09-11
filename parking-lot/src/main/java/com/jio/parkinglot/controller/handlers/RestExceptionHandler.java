package com.jio.parkinglot.controller.handlers;

import com.jio.parkinglot.constants.ResponseCode;
import com.jio.parkinglot.exceptions.ResourceCreationFailedException;
import com.jio.parkinglot.exceptions.ResourceNotFoundException;
import com.jio.parkinglot.response.shared.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> resourceNotFoundHandler(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new Response(ex.getErrorResponse()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceCreationFailedException.class)
    public ResponseEntity<Response> resourceCreationFailed(ResourceCreationFailedException ex, WebRequest request) {
        return new ResponseEntity<>(new Response(ex.getErrorResponse()), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> unhandled(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new Response(ResponseCode.SERVER_ERROR), HttpStatus.NOT_FOUND);
    }
}
