package br.com.stocksmaps.domain.enums;

public enum StatusCarteiraEnum {

    ATIVA('A'),
    INATIVA('I');

    private final Character value;

    StatusCarteiraEnum(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public static StatusCarteiraEnum find(final char value) {
        for (StatusCarteiraEnum type : StatusCarteiraEnum.values())
            if (type.getValue() == value)
                return type;

        return null;
    }

}
