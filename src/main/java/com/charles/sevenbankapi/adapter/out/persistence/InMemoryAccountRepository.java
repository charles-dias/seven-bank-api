package com.charles.sevenbankapi.adapter.out.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.charles.sevenbankapi.application.assembler.AccountAssembler;
import com.charles.sevenbankapi.application.dto.DepositFundsRequest;
import com.charles.sevenbankapi.application.dto.AccountResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.charles.sevenbankapi.application.port.out.AccountRepository;
import com.charles.sevenbankapi.domain.model.Account;

@Repository
@Primary
public class InMemoryAccountRepository implements AccountRepository {

    private final Map<Long, Account> storage = new ConcurrentHashMap<>();

    public InMemoryAccountRepository() {
        // data mocked
        var acc1 = new Account(132L, BigDecimal.valueOf(1000.00), LocalDateTime.now());
        var acc2 = new Account(223L, BigDecimal.valueOf(500.50), LocalDateTime.now());
        var acc3 = new Account(331L, BigDecimal.valueOf(10), LocalDateTime.now());

        storage.put(acc1.accountNumber, acc1);
        storage.put(acc2.accountNumber, acc2);
        storage.put(acc3.accountNumber, acc3);
    }

    @Override
    public Account save(Account account) {
        storage.put(account.accountNumber, account);

        return storage.get(account.accountNumber);
    }

    @Override
    public Optional<Account> findByAccountNumber(Long accountNumber) {
        return Optional.ofNullable(storage.get(accountNumber));
    }
}
