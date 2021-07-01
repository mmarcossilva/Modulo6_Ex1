package com.meli.modulo6_ex1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    Database database = new Database();

    public Pedido salvarPedidos(Pedido pedido) {
        Mesa mesa = database.getMesa(pedido.getMesaId());
        mesa.addPedido(pedido);
        return pedido;
    }

    public double getTotalMesa(int mesaId) {
        Mesa mesa = database.getMesa(mesaId);
        return mesa.getValorConsumido();
    }

    public List<Pedido> getPedidosDaMesa(int mesaId) {
        return database.getMesa(mesaId).getPedidos();
    }

    public void removerPedidos(int mesaId) {
        database.getMesa(mesaId).setPedidos(new ArrayList<Pedido>());
    }

    public double getCaixa() {
        return database.getMesas().stream().mapToDouble(Mesa::getValorConsumido).sum();
    }
}
