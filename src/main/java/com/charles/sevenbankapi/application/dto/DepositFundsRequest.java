package com.charles.sevenbankapi.application.dto;

import lombok.Data;

import java.math.BigDecimal;

public record DepositFundsRequest(Long accountNumber, BigDecimal value) {
}
