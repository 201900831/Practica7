package com.rioja.wineCellar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("USER")
public class User {
    private @Column("USER_ID") @Id int userId;
	private @Column("USER_NAME") char userName;
	private @Column("USER_PASSWORD") char userPassword;
	private @Column("EMAIL") char email;
    private @Column("COUNTRY") char country;
    private @Column("HOME_ADDRESS") char address;
}
