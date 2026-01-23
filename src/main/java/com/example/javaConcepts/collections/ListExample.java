package com.example.javaConcepts.collections;

import java.util.ArrayList;
import java.util.List;

import com.example.javaConcepts.collections.models.Pessoa;

public class ListExample { // Em collections, List é uma coleção ordenada que permite elementos duplicados. Ideal para armazenar sequências de itens em que a ordem importa e duplicatas são permitidas.
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(1L, "João"));
        Pessoa a = pessoas.get(0);

        for (Pessoa pessoa: pessoas) {
            System.out.println(pessoa.getNome());
        }

        System.out.println("-----------");
        pessoas.add(a);

        for (Pessoa pessoa: pessoas) {
            System.out.println(pessoa.getNome());
        }
    }
}
