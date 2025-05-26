package com.charles.sevenbankapi.application.service;

import com.charles.sevenbankapi.application.assembler.AccountAssembler;
import com.charles.sevenbankapi.application.dto.DepositFundsRequest;
import com.charles.sevenbankapi.application.dto.AccountResponse;
import com.charles.sevenbankapi.application.port.in.DepositFundsUseCase;
import com.charles.sevenbankapi.application.port.out.AccountRepository;
import com.charles.sevenbankapi.common.exception.ResourceNotFoundException;
import com.charles.sevenbankapi.domain.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepositFundsService implements DepositFundsUseCase {
    private final AccountRepository accountRepository;

    public DepositFundsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public AccountResponse execute(DepositFundsRequest request) throws ResourceNotFoundException {
        Account account = accountRepository.findByAccountNumber(
                request.accountNumber()).orElseThrow(() ->
                new ResourceNotFoundException(request.accountNumber()));

        account.deposit(request.value());

        Account updatedAccount = accountRepository.save(account);

        return AccountAssembler.toResponseModel(updatedAccount);
    }
}
