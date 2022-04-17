package com.rioja.wineCellar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("WINE")
public class Wine {
    @Id
    private String id;

    private String wineName;
    private int year;
    private String description;
}
