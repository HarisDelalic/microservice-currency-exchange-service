package com.dela.microservicecurrencyexchangeservice.repositories;

import com.dela.microservicecurrencyexchangeservice.models.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    Optional<ExchangeValue> findByFromAndAndTo(String from, String to);
}
