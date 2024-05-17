package com.wzz.cedulas.resource;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
public class CedulasResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private double valor;
    private String tipoCedula;
    private boolean possuiNotaFiscal;
    private String valorFormatado;
    private String descricao;
    private String notaFiscal;
}