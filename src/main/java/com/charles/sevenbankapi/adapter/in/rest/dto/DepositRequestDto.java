package com.charles.sevenbankapi.adapter.in.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DepositRequestDto(
        @NotNull @Positive BigDecimal value
) { }
