package com.example.javaConcepts.streamAPI.models;

import java.util.List;

public class Pedido {
    private String id;
    private boolean pago;
    private List<Item> itens;

    public Pedido(String id, boolean pago, List<Item> itens) {
        this.id = id;
        this.pago = pago;
        this.itens = itens;
    }

    public String getId() {
        return id;
    }

    public boolean isPago() {
        return pago;
    }

    public List<Item> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", pago=" + pago +
                ", itens=" + itens +
                '}';
    }
}
