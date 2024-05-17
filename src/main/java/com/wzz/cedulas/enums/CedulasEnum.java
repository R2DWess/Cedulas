package com.wzz.cedulas.enums;

public enum CedulasEnum {
    REAL("Real", "BRL", "123456789", "R$"),
    DOLAR("Dolar", "USD", "987654321", "U$"),
    EURO("Euro", "EUR", "112233445", "€");

    private final String descricao;
    private final String codigo;
    private final String id;
    private final String symbol;

    CedulasEnum(String descricao, String codigo, String id, String symbol) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.id = id;
        this.symbol = symbol;
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

    public String getSymbol() {
        return symbol;
    }

    public static CedulasEnum findById(String id) {
        for (CedulasEnum cedula : values()) {
            if (cedula.id.equals(id)) {
                return cedula;
            }
        }
        return null; // Retorna null se o id não for encontrado
    }

    public static String getSymbolById(String id) {
        CedulasEnum cedula = findById(id);
        if (cedula != null) {
            return cedula.getSymbol();
        } else {
            return ""; // Retorna uma string vazia ou algum valor padrão
        }
    }
}
