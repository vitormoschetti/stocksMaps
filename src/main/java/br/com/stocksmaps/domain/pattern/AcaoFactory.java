package br.com.stocksmaps.domain.pattern;

import br.com.stocksmaps.domain.entities.Acao;
import br.com.stocksmaps.domain.entities.Ativo;
import br.com.stocksmaps.domain.pattern.interfaces.FactoryAtivo;

public class AcaoFactory implements FactoryAtivo<Acao> {

    @Override
    public Acao create(Ativo input) {
        final var acao = new Acao();
        acao.criar(input);
        return acao;
    }
}