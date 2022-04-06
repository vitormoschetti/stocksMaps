package br.com.stocksmaps.domain.enums;

public enum StatusEnum {

    ATIVA('A'),
    INATIVA('I');

    private final Character value;

    StatusEnum(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public static StatusEnum find(final char value) {
        for (StatusEnum type : StatusEnum.values())
            if (type.getValue() == value)
                return type;

        return null;
    }

}
