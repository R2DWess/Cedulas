package com.wzz.cedulas.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjetoFurtadoRevisarResource {
    private String tipo;
    private double valor;
    private String tipoCedula;
    private boolean notaFiscal;
    private LocalDateTime dataCompra;
    private String valorFormatado;
    private String descricao;
}
