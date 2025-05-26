package com.charles.sevenbankapi.application.service;

import com.charles.sevenbankapi.application.assembler.AccountAssembler;
import com.charles.sevenbankapi.application.dto.AccountResponse;
import com.charles.sevenbankapi.application.port.in.GetBalanceUseCase;
import com.charles.sevenbankapi.application.port.out.AccountRepository;
import com.charles.sevenbankapi.common.exception.ResourceNotFoundException;
import com.charles.sevenbankapi.domain.model.Account;
import org.springframework.stereotype.Service;

@Service
public class GetBalanceService implements GetBalanceUseCase {
    private final AccountRepository accountRepo;

    public GetBalanceService(AccountRepository accountRepository) {
        this.accountRepo = accountRepository;
    }

    @Override
    public AccountResponse execute(Long accountNumber) {
        Account account = accountRepo.findByAccountNumber(accountNumber).orElseThrow(() -> new ResourceNotFoundException(accountNumber));

        return AccountAssembler.toResponseModel(account);
    }
}
