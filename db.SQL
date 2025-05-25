
DROP DATABASE IF EXISTS usagiryori;

-- Create the database
CREATE DATABASE usagiryori;

-----------------------------------------------------------------------------------------------
-- Use the database
-----------------------------------------------------------------------------------------------
\c usagiryori
-- USE usagiryori; -- Uncomment this line instead if you're using MySQL or SQL Server

-- Create TABLE
CREATE TABLE "table" (
    idtable VARCHAR(50) PRIMARY KEY,
    designation VARCHAR(100) NOT NULL,
    occupation BOOLEAN NOT NULL
);

-- Create MENU
CREATE TABLE menu (
    idplat VARCHAR(50) PRIMARY KEY,
    nomplat VARCHAR(100) NOT NULL,
    pu INT NOT NULL
);

-- Create COMMANDE
CREATE TABLE commande (
    idcom VARCHAR(50) NOT NULL,
    idplat VARCHAR(50) NOT NULL,
    nomcli VARCHAR(100) NOT NULL,
    typecom VARCHAR(50) NOT NULL,
    idtable VARCHAR(50) NOT NULL,
    datecom DATE NOT NULL,
    CONSTRAINT PK_COMMANDE PRIMARY KEY (idcom, idplat),
    FOREIGN KEY (idplat) REFERENCES menu(idplat),
    FOREIGN KEY (idtable) REFERENCES "table"(idtable)
);

-- Create RESERVER
CREATE TABLE reserver (
    idreserv VARCHAR(50),
    idtable VARCHAR(50) NOT NULL,
    date_de_reserv TIMESTAMP NOT NULL,
    date_reserve TIMESTAMP NOT NULL,
    nomcli VARCHAR(100) NOT NULL,
    CONSTRAINT PK_RESERVER PRIMARY KEY (idreserv, idtable, date_reserve),
    FOREIGN KEY (idtable) REFERENCES "table"(idtable)
);
