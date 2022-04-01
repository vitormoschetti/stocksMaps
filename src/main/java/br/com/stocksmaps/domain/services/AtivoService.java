package br.com.stocksmaps.domain.services;

import br.com.stocksmaps.application.dtos.inputModel.AtivosInputModel;
import br.com.stocksmaps.application.factories.AtivoInputModelParaListAtivos;
import br.com.stocksmaps.domain.services.interfaces.IAtivoService;
import br.com.stocksmaps.infra.data.repositories.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtivoService implements IAtivoService {

    private final CarteiraRepository carteiraRepository;
    private final AtivoInputModelParaListAtivos factoryToEntity;

    @Autowired
    public AtivoService(CarteiraRepository carteiraRepository, AtivoInputModelParaListAtivos factoryToEntity) {
        this.carteiraRepository = carteiraRepository;
        this.factoryToEntity = factoryToEntity;
    }

    @Override
    public void adicionar(Long idCarteira, AtivosInputModel input) {

        //TODO adicionar validacao se carteira é nula (notification pattern)

        final var carteira = this.carteiraRepository.buscarPorId(idCarteira);

        final var ativos = this.factoryToEntity.create(input);

        carteira.adicionar(ativos);







    }
}
