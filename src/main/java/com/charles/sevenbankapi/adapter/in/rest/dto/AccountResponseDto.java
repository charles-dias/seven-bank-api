package com.charles.sevenbankapi.adapter.in.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// adapter/in/rest/dto/DepositResponseDto.java
public record AccountResponseDto(
        Long accountNumber,
        BigDecimal balance,
        LocalDateTime lastUpdate
) { }