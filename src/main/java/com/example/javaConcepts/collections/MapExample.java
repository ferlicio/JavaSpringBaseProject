package com.example.javaConcepts.collections;

import java.util.HashMap;
import java.util.Map;

import com.example.javaConcepts.collections.models.Pessoa;

public class MapExample { // Em collections, Map armazena pares chave-valor, permitindo valores duplicados e acesso rápido aos valores com base nas chaves. Ideal para buscas eficientes.
    // diferentes implementações de Map incluem HashMap, TreeMap e LinkedHashMap.
    // HashMap não mantém ordem mas é mais rápido.
    // TreeMap ordena os elementos pela chave automaticamente.
    // LinkedHashMap mantém a ordem de inserção.
    public static void main(String[] args) {
        Map<Long, Pessoa> mapa = new HashMap<>();
        Pessoa joao = new Pessoa(1L, "Joao");

        mapa.put(1L, joao);

        Pessoa joao2 = mapa.get(1L);
        System.out.println(joao2.getNome());
    }
}
