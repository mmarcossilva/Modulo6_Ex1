package com.meli.modulo6_ex1;

import java.util.List;

public class PedidosDTO {
    private List<Pedido> pedidos;
    private double total;

    public PedidosDTO(List<Pedido> pedidos, double total) {
        this.pedidos = pedidos;
        this.total = total;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
