package com.rioja.wineCellar.controller;

import com.rioja.wineCellar.model.Elemento;
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
@RequestMapping("/api/v1")
public class ElementoController {
    @Autowired
    private ElementoService elementoService;
    //esto lo hago siempre, me lo cargo 
    
    @GetMapping("/elemento")
    public ResponseEntity<Iterable<ElementoController>> getElemento(@RequestParam(required=false) String foodName) {
        //me va a devolver esto cada vez q llame a este método
        Iterable<ElementoController> response = elementoService.getElemento(foodName);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/elemento/{id}/")
    public ResponseEntity<Elemento> getElemento(@PathVariable String id) {
        Elemento response = elementoService.getElemento(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/elemento/{id}/") //en internet no lo pones entre corchetes
    public ResponseEntity<Elemento> updateElemento(@PathVariable String id, @RequestBody Elemento elemento) {
        Elemento newElemento = elementoService.updateElemento(id, elemento);
        if (newElemento == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newElemento);
    }

    @DeleteMapping("/elemento/{id}")
    public ResponseEntity<Elemento> deleteElemento @PathVariable String id) {
        elementoService.deleteElemento(id);
        return ResponseEntity.noContent().build();
    }
    
}

