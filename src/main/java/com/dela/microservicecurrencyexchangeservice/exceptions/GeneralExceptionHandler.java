package com.dela.microservicecurrencyexchangeservice.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private Environment environment;

    @ExceptionHandler(ConversionNotFoundException.class)
    public ResponseEntity<ExceptionResponse> getResponse(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(),
                Integer.parseInt(environment.getProperty("local.server.port"))), HttpStatus.NOT_FOUND);
    }

}
