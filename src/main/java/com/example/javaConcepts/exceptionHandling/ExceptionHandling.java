package com.example.javaConcepts.exceptionHandling;

import com.example.javaConcepts.exceptionHandling.exception.SaldoInsuficienteException;
import com.example.javaConcepts.exceptionHandling.service.ContaService;

public class ExceptionHandling {
    public static void main(String[] args) {

        ContaService contaService = new ContaService();

        try {
            System.out.println("Iniciando saque...");
            contaService.sacar(100, 150);

            System.out.println("Saque finalizado.");

        } catch (SaldoInsuficienteException e) {
            // Exception de negócio (customizada)
            System.out.println("Erro de negócio: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            // Erro de validação
            System.out.println("Erro de validação: " + e.getMessage());

        } catch (Exception e) {
            // Fallback genérico (último sempre!)
            System.out.println("Erro inesperado");
            e.printStackTrace();

        } finally {
            // Sempre executa
            System.out.println("Finalizando operação (finally).");
        }
    }
}
