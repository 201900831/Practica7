package com.rioja.wineCellar.service.implementation;

import com.rioja.wineCellar.model.Wine;
import com.rioja.wineCellar.repository.WineRepository;
import com.rioja.wineCellar.service.WineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImplementation implements WineService {
    @Autowired
    private WineRepository wineRepository;
    
    @Override
    public Iterable<Wine> retrieveWines(String year) {
        if (year == null) {
            return wineRepository.findAll();
        } else {
            int yearInt = Integer.parseInt(year);
            return wineRepository.retrieveWinesByYear(yearInt);
        }
    }

    @Override
    public Wine retrieveWine(String id) {
        Wine response = null;
        if (wineRepository.existsById(id)) {
            Iterable<Wine> wines = wineRepository.retrieveWine(id);
            for (Wine wine : wines) {
                response = wine;
            }
            return response;
        }
        return response;
    }

    @Override
    public Wine updateWine(String id, Wine wine) {
        if (wineRepository.existsById(id)) {
            return wineRepository.save(wine);
        } else {
            return null;
        }
    }

    @Override
    public void deleteWine(String id) {
        wineRepository.deleteById(id);
    }
}
