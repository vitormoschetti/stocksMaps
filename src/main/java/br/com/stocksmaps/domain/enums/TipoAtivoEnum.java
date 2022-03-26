package br.com.stocksmaps.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAtivoEnum {

    ACAO("A"),
    FUNDO_IMOBILIARIO("FII"),
    STOCK("S"),
    REIT("R");

    private String value;

}
