package br.com.stocksmaps.domain.pattern;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;
import br.com.stocksmaps.domain.entities.Acao;
import br.com.stocksmaps.domain.enums.SetorAcaoEnum;

public class AcaoStrategy implements Strategy<Acao> {

    @Override
    public Acao create(AtivoInputModel input) {
        final var acao = new Acao(SetorAcaoEnum.valueOf(input.getSegmento()));
        acao.criarAtivo(input);
        return acao;
    }
}
