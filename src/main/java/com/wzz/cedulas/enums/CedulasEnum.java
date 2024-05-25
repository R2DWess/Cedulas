package com.wzz.cedulas.enums;

import java.util.NoSuchElementException;

public enum CedulasEnum {
    REAL("Real", "BRL", "123456789", "R$"),
    DOLAR("Dolar", "USD", "987654321", "U$"),
    EURO("Euro", "EUR", "112233445", "€");

    private final String descricao;
    private final String codigo;
    private final String id;
    private final String simbolo;

    CedulasEnum(String descricao, String codigo, String id, String simbolo) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.id = id;
        this.simbolo = simbolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getId() {
        return id;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public static CedulasEnum findById(String id) {
        for (CedulasEnum cedula : values()) {
            if (cedula.id.equals(id)) {
                return cedula;
            }
        }
        throw new NoSuchElementException("No enum constant for id: " + id);
    }
}
