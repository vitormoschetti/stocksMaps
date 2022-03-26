package br.com.stocksmaps.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SegmentoReitEnum {

    LOGISTICA("L"),
    SHOPPING("S"),
    HIBRIDO("H"),
    PAPEL("P"),
    LAJES_CORPORATIVAS("LC");

    private String value;

}