package com.dela.microservicecurrencyexchangeservice.controllers;

import com.dela.microservicecurrencyexchangeservice.exceptions.ConversionNotFoundException;
import com.dela.microservicecurrencyexchangeservice.models.ExchangeValue;
import com.dela.microservicecurrencyexchangeservice.repositories.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-converter/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        Optional<ExchangeValue> exchangeValueOptional = exchangeValueRepository.findByFromAndAndTo(from, to);
        if (exchangeValueOptional.isEmpty())
            throw new ConversionNotFoundException(from, to);
        ExchangeValue exchangeValue = exchangeValueOptional.get();
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
