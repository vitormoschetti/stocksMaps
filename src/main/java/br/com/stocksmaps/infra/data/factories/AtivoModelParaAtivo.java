package br.com.stocksmaps.infra.data.factories;

import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Ativo;
import br.com.stocksmaps.infra.data.models.AtivoModel;
import org.springframework.stereotype.Component;

@Component
public class AtivoModelParaAtivo implements IFactoryWithParams<AtivoModel, Ativo> {

    @Override
    public Ativo create(AtivoModel ativoModel) {
        final var ativo = new Ativo() {
            @Override
            protected void validar() {

            }
        };

        ativo.criar(ativoModel);

        return ativo;
    }
}
