
CREATE SCHEMA IF NOT EXISTS oblig4;
SET search_path TO oblig4;

CREATE TABLE Bruker
(
    mobil CHAR(8) PRIMARY KEY,
    fornavn VARCHAR,
    etternavn VARCHAR,
    salt VARCHAR,
    passord VARCHAR,
    kjonn VARCHAR CHECK ( kjonn= 'mann' OR kjonn='kvinne')
)