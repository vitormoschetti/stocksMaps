package br.com.stocksmaps.domain.entities;

import lombok.Getter;

@Getter
public class FundoImobiliario extends Ativo {

    public FundoImobiliario(Ativo ativo) {
        this.criar(ativo);
    }

    @Override
    protected void validar() {

    }
}
