CREATE SCHEMA IF NOT EXISTS basic;

CREATE TABLE IF NOT EXISTS basic.basic (
    id                  UUID PRIMARY KEY,
    name                TEXT NOT NULL,
    description         TEXT
);

CREATE TABLE IF NOT EXISTS basic.sub_basic (
    id                  UUID PRIMARY KEY,
    x                   INT NOT NULL,
    y                   INT NOT NULL,
    basic_id            UUID NOT NULL REFERENCES basic.basic(id)
);