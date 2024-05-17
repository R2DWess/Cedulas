package com.wzz.cedulas.dto;

import lombok.Data;

@Data
public class CedulasDto {
    private Long id;
    private String tipo;
    private double valor;
    private String tipoCedula;
    private boolean possuiNotaFiscal;
    private String valorFormatado;
    private String descricao;
}