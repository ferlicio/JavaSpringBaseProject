package com.example.javaConcepts.streamAPI;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.javaConcepts.streamAPI.models.Item;
import com.example.javaConcepts.streamAPI.models.Pedido;

public class StreamExamples {
    public static void main(String[] args) {

        List<Pedido> pedidos = criarPedidos();

        // Ao usar Stream API, podemos realizar várias operações de forma concisa e eficiente.
        // Aqui estão alguns exemplos comuns:

        // 1️⃣ Filtrar pedidos pagos
        List<Pedido> pedidosPagos =
                pedidos.stream()
                        .filter(Pedido::isPago)
                        .toList();

        System.out.println("Pedidos pagos:");
        pedidosPagos.forEach(System.out::println);

        // 2️⃣ Map: extrair IDs
        List<String> ids =
                pedidos.stream()
                        .map(Pedido::getId)
                        .toList();

        System.out.println("\nIDs dos pedidos:");
        ids.forEach(System.out::println);

        // 3️⃣ flatMap: todos os itens de todos os pedidos
        List<Item> todosItens =
                pedidos.stream()
                        .flatMap(p -> p.getItens().stream())
                        .toList();

        System.out.println("\nTodos os itens:");
        todosItens.forEach(System.out::println);

        // 4️⃣ distinct: nomes únicos de itens
        Set<String> nomesUnicos =
                pedidos.stream()
                        .flatMap(p -> p.getItens().stream())
                        .map(Item::getNome)
                        .collect(Collectors.toSet());

        System.out.println("\nNomes únicos:");
        nomesUnicos.forEach(System.out::println);

        // 5️⃣ groupingBy: itens agrupados por nome
        Map<String, List<Item>> itensPorNome =
                pedidos.stream()
                        .flatMap(p -> p.getItens().stream())
                        .collect(Collectors.groupingBy(Item::getNome));

        System.out.println("\nItens agrupados por nome:");
        itensPorNome.forEach((k, v) -> System.out.println(k + " -> " + v));

        // 6️⃣ toMap: pedido por ID
        Map<String, Pedido> pedidoPorId =
                pedidos.stream()
                        .collect(Collectors.toMap(
                                Pedido::getId,
                                Function.identity()
                        ));

        System.out.println("\nPedido P002:");
        System.out.println(pedidoPorId.get("P002"));

        // 7️⃣ reduce: valor total de todos os itens
        double valorTotal =
                pedidos.stream()
                        .flatMap(p -> p.getItens().stream())
                        .map(Item::getPreco)
                        .reduce(0.0, Double::sum);

        System.out.println("\nValor total dos itens: R$ " + valorTotal);

        // 8️⃣ anyMatch / allMatch
        boolean existePedidoPago =
                pedidos.stream().anyMatch(Pedido::isPago);

        boolean todosPagos =
                pedidos.stream().allMatch(Pedido::isPago);

        System.out.println("\nExiste pedido pago? " + existePedidoPago);
        System.out.println("Todos pagos? " + todosPagos);


        // outra forma de lidar com coleções grandes é usando paralelStream()
        // isso pode melhorar a performance em operações que podem ser paralelizadas
        // ✔ Tarefa pesada?
        // ✔ Muito dado?
        // ✔ Sem I/O?
        // ✔ Sem estado mutável?
        // ✔ Ordem não importa?
        // Se a resposta for sim para tudo, pode testar.

        // 9️⃣ paralelStream: valor total de todos os itens (paralelo)
        double valorTotalParalelo =
                pedidos.parallelStream()
                        .flatMap(p -> p.getItens().stream())
                        .mapToDouble(Item::getPreco)
                        .sum();
        
        System.out.println("\nValor total dos itens (paralelo): R$ " + valorTotalParalelo);
    }

    private static List<Pedido> criarPedidos() {
        return List.of(
                new Pedido(
                        "P001",
                        true,
                        List.of(
                                new Item("Notebook", 3500),
                                new Item("Mouse", 80)
                        )
                ),
                new Pedido(
                        "P002",
                        false,
                        List.of(
                                new Item("Teclado", 200),
                                new Item("Mouse", 80)
                        )
                ),
                new Pedido(
                        "P003",
                        true,
                        List.of(
                                new Item("Monitor", 1200)
                        )
                )
        );
    }
}
