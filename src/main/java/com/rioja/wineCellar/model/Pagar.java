package com.rioja.wineCellar.model;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("PAGAR")
public class Pagar {
    private @Column("PRICE") float price;
    private @Column("USER_ID") int userId;
    private @Column("HOME_ADDRESS") char address;
}