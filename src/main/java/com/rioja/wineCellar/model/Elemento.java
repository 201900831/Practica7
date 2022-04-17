package com.rioja.wineCellar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("ELEMENTO")
public class Elemento {
    private @Column("FOOD_ID") @Id int foodId;
	private @Column("FOOD_NAME") char foodName;
	private @Column("PRICE") float price;
	private @Column("INGREDIENTES") char ingredientes;
    private @Column("KALORIES") float kalories;
}
