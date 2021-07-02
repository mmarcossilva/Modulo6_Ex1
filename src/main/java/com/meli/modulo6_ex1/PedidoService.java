package com.meli.modulo6_ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    MesaRepository repository;

    public Pedido salvarPedidos(Pedido pedido) {
        Mesa mesa = this.getMesaById(pedido.getMesaId());
        mesa.addPedido(pedido);
        repository.alterMesa(mesa);
        return pedido;
    }

    private Mesa getMesaById(int id){
        return repository.getList().stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    public double getTotalMesa(int mesaId) {
        return getMesaById(mesaId).getValorConsumido();
    }

    public List<Pedido> getPedidosDaMesa(int mesaId) {
        return this.getMesaById(mesaId).getPedidos();
    }

    public void removerPedidos(int mesaId) {
        Mesa mesa = this.getMesaById(mesaId);
        mesa.setPedidos(new ArrayList<Pedido>());
        repository.alterMesa(mesa);
    }

    public double getCaixa() {
        return repository.getList().stream().mapToDouble(Mesa::getValorConsumido).sum();
    }
}
