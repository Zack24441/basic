CREATE SCHEMA IF NOT EXISTS basic;

CREATE TABLE IF NOT EXISTS basic (
    id                  UUID PRIMARY KEY,
    name                TEXT NOT NULL,
    description         TEST
);

CREATE TABLE IF NOT EXISTS sub_basic (
    id                  UUID PRIMARY KEY,
    x                   INT NOT NULL,
    y                   INT NOT NULL,
    basic_id            UUID REFERENCES basic(id)
);