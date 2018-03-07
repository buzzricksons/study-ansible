CREATE TABLE STOCK
(
    SERIAL                      varchar(100) NOT NULL,
    NAME                        varchar(8) NOT NULL,
    AMOUNT                      DECIMAL(14,0) NOT NULL,
    CONSTRAINT STOCK_PK PRIMARY KEY (SERIAL)
);
CREATE TABLE SELL
(
    SERIAL                      varchar(100) NOT NULL,
    NAME                        varchar(8) NOT NULL,
    AMOUNT                      DECIMAL(14,0) NOT NULL,
    PRICE                       DECIMAL(14,0) NOT NULL,
    SALE                        DECIMAL(14,0) NOT NULL,
    CONSTRAINT SELL_PK PRIMARY KEY (SERIAL),
);