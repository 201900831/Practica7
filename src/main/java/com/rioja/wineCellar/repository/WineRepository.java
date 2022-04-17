package com.rioja.wineCellar.repository;

import com.rioja.wineCellar.model.Wine;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface WineRepository extends CrudRepository<Wine, String> {
    @Query("SELECT * FROM WINE WHERE WINE.YEAR= :year")
    public Iterable<Wine> retrieveWinesByYear(int year);

    @Query("SELECT * FROM WINE WHERE WINE.ID= :id")
    public Iterable<Wine> retrieveWine(String id);
}
