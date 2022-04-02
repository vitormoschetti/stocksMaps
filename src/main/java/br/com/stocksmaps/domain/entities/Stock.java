package br.com.stocksmaps.domain.entities;

import lombok.Getter;

@Getter
public class Stock extends Ativo {

    public Stock(Ativo ativo) {
        this.criar(ativo);
    }

    @Override
    protected void validar() {

    }
}
