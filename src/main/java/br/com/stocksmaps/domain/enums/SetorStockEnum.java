package br.com.stocksmaps.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SetorStockEnum {

    COMUNICACAO("C"),
    CONSUMO_CICLICO("CC"),
    CONSUMO_NAO_CICLICO("CNC"),
    FINANCEIRO("F"),
    SAUDE("S"),
    UTILIDADE_PUBLICA("UP");

    private String value;


}
