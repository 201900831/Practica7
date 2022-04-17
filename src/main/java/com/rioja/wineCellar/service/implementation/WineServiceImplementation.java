package com.rioja.wineCellar.service.implementation;

import com.rioja.wineCellar.model.Elemento;
import com.rioja.wineCellar.repository.WineRepository;
import com.rioja.wineCellar.service.WineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImplementation implements WineService {
    @Autowired
    private WineRepository wineRepository;
    
    @Override
    public Iterable<Elemento> retrieveWines(String year) {
        if (year == null) {
            return wineRepository.findAll();
        } else {
            int yearInt = Integer.parseInt(year);
            return wineRepository.retrieveWinesByYear(yearInt);
        }
    }

    @Override
    public Elemento retrieveWine(String id) {
        Elemento response = null;
        if (wineRepository.existsById(id)) {
            Iterable<Elemento> wines = wineRepository.retrieveWine(id);
            for (Elemento wine : wines) {
                response = wine;
            }
            return response;
        }
        return response;
    }

    @Override
    public Elemento updateWine(String id, Elemento wine) {
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
