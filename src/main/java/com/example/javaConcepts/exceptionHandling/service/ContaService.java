package com.example.javaConcepts.exceptionHandling.service;

import com.example.javaConcepts.exceptionHandling.exception.SaldoInsuficienteException;

public class ContaService {
    public void sacar(double saldo, double valor) throws SaldoInsuficienteException, IllegalArgumentException {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser maior que zero");
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente. Saldo atual: " + saldo
            );
        }

        System.out.println("Saque realizado com sucesso: R$ " + valor);
    }
}
