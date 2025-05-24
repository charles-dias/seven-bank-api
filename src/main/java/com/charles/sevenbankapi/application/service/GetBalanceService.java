package com.charles.sevenbankapi.application.service;

import com.charles.sevenbankapi.application.port.in.GetBalanceUseCase;
import com.charles.sevenbankapi.application.port.out.AccountRepository;
import com.charles.sevenbankapi.domain.model.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class GetBalanceService implements GetBalanceUseCase {
    private final AccountRepository accountRepo;

    public GetBalanceService(AccountRepository accountRepository) {
        this.accountRepo = accountRepository;
    }

    @Override
    public Account execute(Long accountNumber) throws Exception {
        return accountRepo.findByAccountNumber(accountNumber).orElseThrow(() -> new Exception(accountNumber.toString()));
    }
}
