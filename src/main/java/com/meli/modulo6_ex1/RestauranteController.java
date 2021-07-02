package com.meli.modulo6_ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestauranteController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> insertPedido(@RequestBody Pedido pedido){
        return new ResponseEntity<>(pedidoService.salvarPedidos(pedido), HttpStatus.ACCEPTED);
    }

    @GetMapping("/pedidos/{mesaId}")
    public ResponseEntity<PedidosDTO> getPedidosMesa(@PathVariable int mesaId){
        return new ResponseEntity<>(new PedidosDTO(pedidoService.getPedidosDaMesa(mesaId), pedidoService.getTotalMesa(mesaId)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/fechamento/{mesaId}")
    public ResponseEntity<String> fecharMesa(@PathVariable int mesaId){
        pedidoService.removerPedidos(mesaId);
        return new ResponseEntity<>("Pedidos da mesa " + mesaId + " foram excluidos", HttpStatus.ACCEPTED);
    }

    @GetMapping("/caixa")
    public ResponseEntity<Double> getCaixa(){
        return new ResponseEntity<>(pedidoService.getCaixa(), HttpStatus.ACCEPTED);
    }

}
