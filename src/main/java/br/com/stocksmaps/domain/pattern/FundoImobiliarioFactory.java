package br.com.stocksmaps.domain.pattern;

import br.com.stocksmaps.domain.entities.Ativo;
import br.com.stocksmaps.domain.entities.FundoImobiliario;
import br.com.stocksmaps.domain.pattern.interfaces.FactoryAtivo;

public class FundoImobiliarioFactory implements FactoryAtivo<FundoImobiliario> {

    @Override
    public FundoImobiliario create(Ativo input) {
        final var fii = new FundoImobiliario();
        fii.criar(input);
        return fii;
    }
}
