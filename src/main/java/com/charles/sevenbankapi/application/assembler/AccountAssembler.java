package com.charles.sevenbankapi.application.assembler;

import com.charles.sevenbankapi.application.dto.AccountResponse;
import com.charles.sevenbankapi.application.dto.DepositFundsRequest;
import com.charles.sevenbankapi.domain.model.Account;
import java.time.LocalDateTime;

public final class AccountAssembler {
    private AccountAssembler(){
        throw new UnsupportedOperationException("Utility class");
    }

    public static Account toDomain(DepositFundsRequest req) {
        return new Account(
                req.accountNumber(),
                req.value(),
                LocalDateTime.now()
        );
    }

    public static AccountResponse toResponseModel(Account account) {
        return new AccountResponse(
                account.getAccountNumber(),
                account.getBalance(),
                account.getLastUpdate()
        );
    }
}
