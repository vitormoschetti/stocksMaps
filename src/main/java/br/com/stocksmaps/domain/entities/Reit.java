package br.com.stocksmaps.domain.entities;

import lombok.Getter;

@Getter
public class Reit extends Ativo {

    public Reit(Ativo ativo) {
        this.criar(ativo);
    }

    @Override
    protected void validar() {

    }
}
