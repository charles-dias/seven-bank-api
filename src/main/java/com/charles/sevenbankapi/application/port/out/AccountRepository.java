package com.charles.sevenbankapi.application.port.out;

import com.charles.sevenbankapi.domain.model.Account;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findByAccountNumber(Long accountNumber);
}
