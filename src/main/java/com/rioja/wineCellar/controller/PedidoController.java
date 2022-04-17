package com.rioja.wineCellar.controller;

import com.rioja.wineCellar.model.Pedido;
import com.rioja.wineCellar.service.WineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pedido/v1")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    //esto lo hago siempre, me lo cargo 
    
    @GetMapping("/pedido")
    public ResponseEntity<Iterable<PedidoController>> getPedido(@RequestParam(required=false) String id) {
        //me va a devolver esto cada vez q llame a este método
        Iterable<PedidoController> response = pedidoService.getPedido(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/pedido/{id}/")
    public ResponseEntity<Pedido> getPago(@PathVariable String id) {
        Pedido response = pedidoService.getPago(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/pedido/{id}/") //en internet no lo pones entre corchetes
    public ResponseEntity<Pedido> updatepago(@PathVariable String id, @RequestBody Pedido pedido) {
        Pedido newPedido = pedidoService.updatePedido(id, pedido);
        if (newPedido == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newPedido);
    }

    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<Pagar> deletePedido @PathVariable String id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
    
}

// /pagar/ (Crear, Coger)
// /pagar/{id} (Coger un elemento, actualizar, eleminar)