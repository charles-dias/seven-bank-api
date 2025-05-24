package com.charles.sevenbankapi.domain.model;

import com.charles.sevenbankapi.application.port.out.AccountRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
public class Account {
    public final Long id;
    public Long accountNumber;
    public BigDecimal balance;

    public Account(Long id, Long accountNumber, BigDecimal balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
