package com.meli.modulo6_ex1;

import java.util.List;

public class Mesa {
    private int id;
    private List<Pedido> pedidos;
    private double valorConsumido;

    public Mesa(int id, List<Pedido> pedidos, double valorConsumido) {
        this.id = id;
        this.pedidos = pedidos;
        this.valorConsumido = valorConsumido;
    }

    public void addPedido(Pedido pedido){
        this.valorConsumido += pedido.getValorTotal();
        this.pedidos.add(pedido);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getValorConsumido() {
        return valorConsumido;
    }

    public void setValorConsumido(double valorConsumido) {
        this.valorConsumido = valorConsumido;
    }
}
