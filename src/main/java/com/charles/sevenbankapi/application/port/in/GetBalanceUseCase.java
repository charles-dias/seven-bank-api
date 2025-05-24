package com.charles.sevenbankapi.application.port.in;

import com.charles.sevenbankapi.domain.model.Account;

public interface GetBalanceUseCase {
    Account execute(Long accountNumber) throws Exception;
}