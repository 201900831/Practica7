package com.rioja.wineCellar.controller;

import com.rioja.wineCellar.model.Wine;
import com.rioja.wineCellar.service.WineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class WineController {
    @Autowired
    private WineService wineService;
    //esto lo hago siempre, me lo cargo 
    
    @GetMapping("/wines")
    public ResponseEntity<Iterable<Wine>> retrieveWines(@RequestParam(required=false) String year) {
        //me va a devolver esto cada vez q llame a este método
        Iterable<Wine> response = wineService.retrieveWines(year);
        return ResponseEntity.ok().body(response);
    }

    // @PostMapping("/wines")
    // public ResponseEntity<Wine> createWine(@RequestBody Wine wine) {
    //     Wine newWine = wineService.createWine(wine);
    //     return ResponseEntity.ok().body(newWine);
    // }

    @GetMapping("/wines/{id}/")
    public ResponseEntity<Wine> retrieveWine(@PathVariable String id) {
        Wine response = wineService.retrieveWine(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/wines/{id}/") //en internet no lo pones entre corchetes
    public ResponseEntity<Wine> updateWine(@PathVariable String id, @RequestBody Wine wine) {
        Wine newWine = wineService.updateWine(id, wine);
        if (newWine == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newWine);
    }

    @DeleteMapping("/wines/{id}")
    public ResponseEntity<Wine> deleteWine(@PathVariable String id) {
        wineService.deleteWine(id);
        return ResponseEntity.noContent().build();
    }
    
}

// /wines/ (Crear, Coger)
// /wines/{id} (Coger un elemento, actualizar, eleminar)