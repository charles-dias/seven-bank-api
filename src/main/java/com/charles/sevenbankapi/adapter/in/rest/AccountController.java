package com.charles.sevenbankapi.adapter.in.rest;

import com.charles.sevenbankapi.adapter.in.rest.dto.DepositRequestDto;
import com.charles.sevenbankapi.adapter.in.rest.dto.AccountResponseDto;
import com.charles.sevenbankapi.application.dto.AccountResponse;
import com.charles.sevenbankapi.application.dto.DepositFundsRequest;
import com.charles.sevenbankapi.application.port.in.DepositFundsUseCase;
import com.charles.sevenbankapi.application.port.in.GetBalanceUseCase;
import com.charles.sevenbankapi.adapter.in.rest.mapper.AccountDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final GetBalanceUseCase getBalanceUseCase;
    private final DepositFundsUseCase depositFundsUseCase;

    public AccountController(GetBalanceUseCase getBalanceUseCase, DepositFundsUseCase depositFundsUseCase) {
        this.getBalanceUseCase = getBalanceUseCase;
        this.depositFundsUseCase = depositFundsUseCase;
    }

    @GetMapping("/{accountNumber}/balance")
    public AccountResponseDto getBalance(@PathVariable Long accountNumber) {
        AccountResponse account = getBalanceUseCase.execute(accountNumber);

        return AccountDtoMapper.toAccountResponse(account);
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<AccountResponseDto> deposit(@PathVariable Long accountNumber, @RequestBody @Valid DepositRequestDto dto) {
        var request = new DepositFundsRequest(accountNumber, dto.value());
        var response = depositFundsUseCase.execute(request);

        var data = new AccountResponseDto(
                response.accountNumber(),
                response.balance(),
                response.lastUpdate()
        );

        return ResponseEntity.ok(data);
    }
}
