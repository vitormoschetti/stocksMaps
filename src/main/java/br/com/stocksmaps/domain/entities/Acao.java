package br.com.stocksmaps.domain.entities;

import lombok.Getter;

@Getter
public class Acao extends Ativo {

    public Acao(Ativo ativo) {
        this.criar(ativo);
    }

    @Override
    protected void validar() {
    }
}
