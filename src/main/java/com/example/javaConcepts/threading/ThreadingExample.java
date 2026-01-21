package com.example.javaConcepts.threading;

import java.util.Scanner;

import com.example.javaConcepts.threading.runnables.TemporizadorR;
import com.example.javaConcepts.threading.threads.TemporizadorT;

public class ThreadingExample {

	public static void main(String[] args) {
		// threading = permite o programa executar várias tarefas simultaneamente dentro de um único processo
		Scanner scanner = new Scanner(System.in);

		Thread temporizador = new Thread(new TemporizadorR("timer 1", 5000, false)); // cria uma thread usando uma classe que implementa Runnable
		// Thread temporizador = new TemporizadorR("timer 1", 5000, false).toThread(); // implementação alternativa
		// TemporizadorT temporizador = new TemporizadorT("timer 2", 5000, false); // cria uma thread estendendo a classe Thread

		temporizador.setDaemon(true); // define a thread como daemon (opcional) onde assim que a thread principal terminar, esta também termina independentemente de ter terminado ou não

		Thread monitor = new Thread(() -> { // cria uma thread anonima usando expressão lambda
			try {
				temporizador.start(); // inicia a thread temporizador
				temporizador.join(); // aguarda o temporizador terminar
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Temporizador finalizado!");
			System.exit(0); // encerra o programa quando o temporizador terminar
		});

		monitor.start(); // inicia a thread monitor

		System.out.println("você tem 5 segundos para digitar algo: ");
		String resposta = scanner.nextLine(); // aguarda a entrada do usuário
		System.out.println("você digitou: " + resposta);

		scanner.close(); // fecha o scanner


	}

}
