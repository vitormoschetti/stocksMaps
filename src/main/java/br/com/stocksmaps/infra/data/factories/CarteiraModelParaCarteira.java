package br.com.stocksmaps.infra.data.factories;

import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Ativo;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.infra.data.models.CarteiraModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarteiraModelParaCarteira implements IFactoryWithParams<CarteiraModel, Carteira> {

    @Override
    public Carteira create(CarteiraModel carteiraModel) {

        final var factoryAtivos = new AtivoModelParaListAtivos();
        final var ativos = factoryAtivos.create(carteiraModel.getAtivos());

        final var entity = new Carteira();
        entity.fromModel(carteiraModel);
        entity.adicionar(ativos);

        return entity;
    }
}
