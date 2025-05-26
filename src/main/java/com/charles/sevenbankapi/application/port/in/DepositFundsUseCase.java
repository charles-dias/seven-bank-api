package com.charles.sevenbankapi.application.port.in;

import com.charles.sevenbankapi.application.dto.DepositFundsRequest;
import com.charles.sevenbankapi.application.dto.AccountResponse;

public interface DepositFundsUseCase {
    AccountResponse execute(DepositFundsRequest request);
}
