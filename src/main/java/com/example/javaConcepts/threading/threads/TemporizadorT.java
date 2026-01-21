package com.example.javaConcepts.threading.threads;

public class TemporizadorT extends Thread { // use extends Thread quando você PRECISA que a classe seja uma thread, por exemplo para sobreescrever métodos da classe Thread como start() ou join()

    private String nome;
    private double tempo;
    private boolean logging = true;

    public TemporizadorT(String nome, double tempo) {
        this.nome = nome;
        this.tempo = tempo;
        this.logging = true;
    }

    public TemporizadorT(String nome, double tempo, boolean logging) {
        this.nome = nome;
        this.tempo = tempo;
        this.logging = logging;
    }

    @Override
    public void run() {
        int loggingTime = 1 * 1000; // tempo em milissegundos entre cada log

        try {
            if (logging) {
                System.out.println(nome + " iniciado para " + tempo/1000 + " segundos.");
            }

            for (int i = 0; i < (tempo/loggingTime); i++) {
                if (logging && tempo > 0 && i > 0) {
                    System.out.println(nome + " - Temporizador: " + ((tempo/1000) - (loggingTime*i/1000)) + " segundos restantes");
                }
                Thread.sleep(loggingTime); // pausa a thread por loggingTime milissegundos
            }
        } catch (InterruptedException e) {
            System.out.println(nome + " interrompido.");
        }

        if (logging) {
            System.out.println(nome + " terminou.");
        }
    }
    
}
