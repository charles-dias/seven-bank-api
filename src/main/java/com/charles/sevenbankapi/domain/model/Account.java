package com.charles.sevenbankapi.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Account {
    public Long accountNumber;
    public BigDecimal balance;
    public LocalDateTime  lastUpdate;

    public Account(Long accountNumber, BigDecimal balance, LocalDateTime  lastUpdate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lastUpdate = lastUpdate;
    }

    public void deposit(BigDecimal value) {
        if (value.signum() <= 0) {
            throw new IllegalArgumentException("Deposit value must be positive");
        }

        this.balance = this.balance.add(value);
        this.lastUpdate = LocalDateTime.now();
    }
}
