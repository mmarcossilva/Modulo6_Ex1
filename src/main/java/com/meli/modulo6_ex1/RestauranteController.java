package com.meli.modulo6_ex1;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestauranteController {

    PedidoService pedidoService = new PedidoService();

    @PostMapping("/pedido")
    public Pedido insertPedido(@RequestBody Pedido pedido){
        return pedidoService.salvarPedidos(pedido);
    }

    @GetMapping("/pedidos/{mesaId}")
    public PedidosDTO getPedidosMesa(@PathVariable int mesaId){
        return new PedidosDTO(pedidoService.getPedidosDaMesa(mesaId), pedidoService.getTotalMesa(mesaId));
    }

    @GetMapping("/fechamento/{mesaId}")
    public void fecharMesa(@PathVariable int mesaId){
        pedidoService.removerPedidos(mesaId);
    }

    @GetMapping("/caixa")
    public double getCaixa(){
        return pedidoService.getCaixa();
    }

}
