package com.dela.microservicecurrencyexchangeservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ExceptionResponse {
    @Getter @Setter private String message;
    @Getter @Setter private int port;
}
