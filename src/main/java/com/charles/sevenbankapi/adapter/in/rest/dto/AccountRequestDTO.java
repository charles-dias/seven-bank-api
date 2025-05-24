package com.charles.sevenbankapi.adapter.in.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountRequestDTO(
        Long id,
        BigDecimal balance,
        LocalDateTime startDate,
        LocalDateTime endDate
) {}
