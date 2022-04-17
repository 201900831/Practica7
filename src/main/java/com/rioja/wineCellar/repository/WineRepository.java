package com.rioja.wineCellar.repository;

import com.rioja.wineCellar.model.Elemento;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface WineRepository extends CrudRepository<Elemento, String> {
    @Query("SELECT * FROM WINE WHERE WINE.YEAR= :year")
    public Iterable<Elemento> retrieveWinesByYear(int year);

    @Query("SELECT * FROM WINE WHERE WINE.ID= :id")
    public Iterable<Elemento> retrieveWine(String id);
}
