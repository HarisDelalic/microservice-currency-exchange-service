package com.dela.microservicecurrencyexchangeservice.exceptions;

public class ConversionNotFoundException extends RuntimeException {

    public ConversionNotFoundException(String from, String to) {
        super("Conversion Multiple For Conversion From " + from + " To " + to + " Not Found");
    }
}
