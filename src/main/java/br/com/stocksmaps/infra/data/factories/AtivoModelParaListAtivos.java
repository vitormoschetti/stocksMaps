package br.com.stocksmaps.infra.data.factories;

import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Ativo;
import br.com.stocksmaps.infra.data.models.AtivoModel;

import java.util.List;
import java.util.stream.Collectors;

public class AtivoModelParaListAtivos implements IFactoryWithParams<List<AtivoModel>, List<Ativo>> {

    @Override
    public List<Ativo> create(List<AtivoModel> ativoModels) {
        return ativoModels.stream().map(ativo -> new AtivoModelParaAtivo().create(ativo)).collect(Collectors.toList());
    }
}
