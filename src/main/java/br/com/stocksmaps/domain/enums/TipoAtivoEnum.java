package br.com.stocksmaps.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAtivoEnum {

    ACAO,
    FUNDO_IMOBILIARIO,
    STOCK,
    REIT;

}
