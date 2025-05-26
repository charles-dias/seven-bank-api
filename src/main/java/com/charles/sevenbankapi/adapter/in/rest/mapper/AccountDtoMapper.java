package com.charles.sevenbankapi.adapter.in.rest.mapper;

import com.charles.sevenbankapi.adapter.in.rest.dto.DepositRequestDto;
import com.charles.sevenbankapi.adapter.in.rest.dto.AccountResponseDto;
import com.charles.sevenbankapi.application.dto.DepositFundsRequest;
import com.charles.sevenbankapi.application.dto.AccountResponse;

import java.time.LocalDateTime;

public class AccountDtoMapper {

    public static DepositFundsRequest toDepositRequest(DepositRequestDto dto, Long accountNumber) {
        return new DepositFundsRequest(accountNumber, dto.value());
    }

    public static AccountResponse toAccountResponse(AccountResponseDto dto, Long accountNumber, LocalDateTime lastUpdate) {
        return new AccountResponse(accountNumber, dto.balance(), lastUpdate);
    }

    public static AccountResponseDto toAccountResponse(AccountResponse dto) {
        return new AccountResponseDto(dto.accountNumber(), dto.balance(), dto.lastUpdate());
    }
}