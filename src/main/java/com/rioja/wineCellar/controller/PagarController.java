package com.rioja.wineCellar.controller;

import com.rioja.wineCellar.model.Pagar;
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
@RequestMapping("/pagar/v1")
public class PagarController {
    @Autowired
    private PagarService pagarService;
    //esto lo hago siempre, me lo cargo 
    
    @GetMapping("/pagar")
    public ResponseEntity<Iterable<PagarController>> getPago(@RequestParam(required=false) String userId) {
        //me va a devolver esto cada vez q llame a este método
        Iterable<PagarController> response = pagarService.getPago(userId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/pagar/{id}/")
    public ResponseEntity<Pagar> getPago(@PathVariable String id) {
        Elemento response = pagoService.getPago(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/pagar/{id}/") //en internet no lo pones entre corchetes
    public ResponseEntity<Pagar> updatepago(@PathVariable String id, @RequestBody Pagar pagar) {
        Pagar newPago = pagarService.updatePago(id, pagar);
        if (newPago == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newPago);
    }

    @DeleteMapping("/pagar/{id}")
    public ResponseEntity<Pagar> deletePago @PathVariable String id) {
        pagarService.deletePago(id);
        return ResponseEntity.noContent().build();
    }
    
}

// /pagar/ (Crear, Coger)
// /pagar/{id} (Coger un elemento, actualizar, eleminar)