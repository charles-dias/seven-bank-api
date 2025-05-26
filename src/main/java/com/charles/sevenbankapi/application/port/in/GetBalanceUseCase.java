package com.charles.sevenbankapi.application.port.in;

import com.charles.sevenbankapi.adapter.in.rest.dto.AccountResponseDto;
import com.charles.sevenbankapi.application.dto.AccountResponse;
import com.charles.sevenbankapi.common.exception.ResourceNotFoundException;

public interface GetBalanceUseCase {
    AccountResponse execute(Long accountNumber);
}