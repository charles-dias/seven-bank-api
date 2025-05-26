package com.charles.sevenbankapi.application.port.out;

import com.charles.sevenbankapi.domain.model.Account;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findByAccountNumber(Long accountNumber);
    Account save(Account request);
}
