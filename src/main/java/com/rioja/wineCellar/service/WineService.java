package com.rioja.wineCellar.service;

import com.rioja.wineCellar.model.Wine;

public interface WineService {
    Iterable<Wine> retrieveWines(String year);
    Wine retrieveWine(String id);
    Wine updateWine(String id, Wine wine);
    void deleteWine(String id);
}
