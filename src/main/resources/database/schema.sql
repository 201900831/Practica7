DROP TABLE IF EXISTS ELEMENTO:
DROP TABLE IF EXISTS PEDIDO
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS PAGAR;
DROP TABLE IF EXISTS PAGAR;

CREATE TABLE  ELEMENTO (
	FOOD_ID INTEGER IDENTITY PRIMARY KEY,
    FOOD_NAME VARCHAR2(20) NOT NULL ,
	PRICE FLOAT, --pueden estar regalando
	INGREDIENTES varchar(100) NOT NULL,
	KALORIES FLOAT 
);

CREATE TABLE  PEDIDO (
	FOOD_ID INTEGER IDENTITY PRIMARY KEY,
    FOOD_NAME VARCHAR2(20) NOT NULL ,
	PRICE FLOAT, --pueden estar regalando
);



CREATE TABLE USER(
    USER_ID INTEGER IDENTITY PRIMARY KEY,
    USER_NAME VARCHAR(45) NOT NULL,
    USER_PASSWORD VARCHAR(45) NOT NULL,
    EMAIL VARCHAR(45) NOT NULL,
    COUNTRY VARCHAR(255) NOT NULL,
    HOME_ADDRESS VARCHAR(45) NOT NULL

);

DROP TABLE IF EXISTS PAGAR;
CREATE TABLE PAGAR(
    PRICE INTEGER IDENTITY PRIMARY KEY,
    USER_ID int(11) NOT NULL,
    HOME_ADDRESS VARCHAR(45) NOT NULL
);

DROP TABLE IF EXISTS DISCOUNT;

CREATE TABLE DISCOUNT(
    DISCOUNT_ID INTEGER IDENTITY PRIMARY KEY,
    PRICE INT(11) NOT NULL,
    PRICE_DISCOUNT INT(11) NOT NULL
);


