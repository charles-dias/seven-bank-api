package com.charles.sevenbankapi.adapter.in.rest;

import com.charles.sevenbankapi.application.port.in.GetBalanceUseCase;
import com.charles.sevenbankapi.domain.model.Account;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final GetBalanceUseCase getBalance;

    public AccountController(GetBalanceUseCase getBalanceUseCase) {
        getBalance = getBalanceUseCase;
    }

    @GetMapping("/{accountNumber}/balance")
    public Account getAccountBalance(@PathVariable Long accountNumber) throws Exception {
        assert getBalance != null;
        return getBalance.execute(accountNumber);
    }
}
