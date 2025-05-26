package com.charles.sevenbankapi.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountResponse(
    Long accountNumber,
    BigDecimal balance,
    LocalDateTime lastUpdate
) {}
