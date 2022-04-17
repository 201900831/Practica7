package com.rioja.wineCellar.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("DISCOUNT")
public class Discount {
    private @Column("DISCOUNT_ID") @Id int discountId;
    private @Column("PRICE") float price;
    private @Column("PRICE_DISCOUNT") float priceDiscount;
}