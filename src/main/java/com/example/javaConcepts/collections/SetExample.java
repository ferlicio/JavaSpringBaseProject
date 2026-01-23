package com.example.javaConcepts.collections;

import java.util.HashSet;
import java.util.Set;

import com.example.javaConcepts.collections.models.Pessoa;

public class SetExample { // Em collections, Set é uma coleção que não permite elementos duplicados. Ideal para armazenar itens únicos.
    // diferentes implementações de Set incluem HashSet, TreeSet e LinkedHashSet.
    // HashSet não mantém ordem mas é mais rápido.
    // TreeSet ordena os elementos automaticamente.
    // LinkedHashSet mantém a ordem de inserção.
    public static void main(String[] args) {
        Set<Pessoa> pessoas = new HashSet<>();
        Pessoa joao = new Pessoa(1L, "João");
        pessoas.add(joao);

        for (Pessoa pessoa: pessoas) {
            System.out.println(pessoa.getNome());
        }

        System.out.println("--------");
        boolean adicionou = pessoas.add(new Pessoa(1L, "João"));
        if (adicionou)
            System.out.println("adicionou ");
        else
            System.out.println("Não adicionou ");

        for (Pessoa pessoa: pessoas) {
            System.out.println(pessoa.getNome());
        }
    }
}
