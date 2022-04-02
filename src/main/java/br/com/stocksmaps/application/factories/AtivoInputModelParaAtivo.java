package br.com.stocksmaps.application.factories;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;
import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Ativo;
import org.springframework.stereotype.Component;

@Component
public class AtivoInputModelParaAtivo implements IFactoryWithParams<AtivoInputModel, Ativo> {

    @Override
    public Ativo create(AtivoInputModel input) {

        final var ativo = new Ativo() {
            @Override
            protected void validar() {
            }
        };

        ativo.criarNovo(input);

        return ativo;

    }
}









