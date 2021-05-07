package com.squadra.desafio.domain;

public enum StatusEnum {

    ATIVO("Ativo"),
    CANCELADO("Cancelado");

    private final String name;

    StatusEnum(String name) {
        this.name = name;
    }
}
