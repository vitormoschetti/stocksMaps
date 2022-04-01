package br.com.stocksmaps.domain.enums;

public enum StatusEnum {

    ATIVA('A'),
    INATIVA('I');

    private final Character valeu;

    StatusEnum(Character value){
        this.valeu = value;
    }

    public Character getValeu() {
        return valeu;
    }
}
