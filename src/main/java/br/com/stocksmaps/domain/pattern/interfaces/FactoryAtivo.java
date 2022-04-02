package br.com.stocksmaps.domain.pattern.interfaces;

import br.com.stocksmaps.domain.entities.Ativo;

public interface FactoryAtivo<T extends Ativo> {

    T create(Ativo input);

}
