package br.com.stocksmaps.application.factories;

import br.com.stocksmaps.application.dtos.inputModel.AtivosInputModel;
import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Ativo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AtivoInputModelParaListAtivos implements IFactoryWithParams<AtivosInputModel, List<Ativo>> {

    @Override
    public List<Ativo> create(AtivosInputModel ativosInputModel) {

        return ativosInputModel.getAtivos().stream().map(ativo -> new AtivoInputModelParaAtivo().create(ativo)).collect(Collectors.toList());

    }
}
