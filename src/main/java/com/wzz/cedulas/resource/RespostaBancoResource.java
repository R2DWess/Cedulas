package com.wzz.cedulas.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespostaBancoResource {
    private String idItem;
    private String metadado;
    private String valor;

}