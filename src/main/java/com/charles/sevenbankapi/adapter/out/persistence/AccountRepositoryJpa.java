package com.charles.sevenbankapi.adapter.out.persistence;

import com.charles.sevenbankapi.application.port.out.AccountRepository;
import com.charles.sevenbankapi.domain.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public class AccountRepositoryJpa implements AccountRepository {
    @Override
    public Optional<Account> findByAccountNumber(Long accountNumber) {
        Account account = new Account(1L, accountNumber, new BigDecimal("42.99"));

        return Optional.of(account);
    }
}
