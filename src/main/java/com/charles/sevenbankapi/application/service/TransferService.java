package com.charles.sevenbankapi.application.service;

import com.charles.sevenbankapi.application.port.in.TransferUseCase;
import org.springframework.stereotype.Service;

@Service
public class TransferService implements TransferUseCase {
    // 1) buscar Conta origem e destino via contaRepo
    // 2) criar uma Transacao (domínio) debitando e creditando
    // 3) persistir tudo via contaRepo/transactionRepo
    // 4) utilizar atomicidade para evitar race concurrence
}