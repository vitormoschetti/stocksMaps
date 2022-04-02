package br.com.stocksmaps.domain.pattern;

import br.com.stocksmaps.domain.entities.Ativo;
import br.com.stocksmaps.domain.entities.Reit;
import br.com.stocksmaps.domain.pattern.interfaces.FactoryAtivo;

public class ReitFactory implements FactoryAtivo<Reit> {

    @Override
    public Reit create(Ativo input) {
        return new Reit(input);
    }
}