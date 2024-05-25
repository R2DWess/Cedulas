package com.wzz.cedulas.dto;

import com.wzz.cedulas.enums.CedulasEnum;
import lombok.Data;

import java.text.NumberFormat;
import java.util.Locale;

@Data
public class CedulasDto {
    private Long id;
    private String tipo;
    private double valor;
    private String tipoCedula;
    private boolean possuiNotaFiscal;
    private String valorFormatado;
    private String descricao;

    public String getValorFormatado() {
        try {
            CedulasEnum cedula = CedulasEnum.findById(this.tipoCedula);
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            numberFormat.setMinimumFractionDigits(2);
            numberFormat.setMaximumFractionDigits(2);
            return cedula.getSimbolo() + " " + numberFormat.format(this.valor);
        } catch (NullPointerException e) {
            return "Moeda não encontrada";
        }
    }
}
