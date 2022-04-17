package com.rioja.wineCellar.service;

import com.rioja.wineCellar.model.Elemento;

public interface WineService {
    Iterable<Elemento> retrieveWines(String year);
    Elemento retrieveWine(String id);
    Elemento updateWine(String id, Elemento wine);
    void deleteWine(String id);
}
