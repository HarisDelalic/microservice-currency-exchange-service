package com.dela.microservicecurrencyexchangeservice.controllers;

import com.dela.microservicecurrencyexchangeservice.exceptions.ConversionNotFoundException;
import com.dela.microservicecurrencyexchangeservice.models.ExchangeValue;
import com.dela.microservicecurrencyexchangeservice.repositories.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-converter/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        return exchangeValueRepository.findByFromAndAndTo(from, to)
                .orElseThrow(() -> new ConversionNotFoundException(from, to));
    }
}
