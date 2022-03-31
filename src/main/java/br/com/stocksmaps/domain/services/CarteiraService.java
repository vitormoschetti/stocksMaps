package br.com.stocksmaps.domain.services;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.application.factories.CarteiraInputModelParaCarteira;
import br.com.stocksmaps.application.factories.CarteiraParaCarteiraViewModel;
import br.com.stocksmaps.domain.repositories.ICarteiraRepository;
import br.com.stocksmaps.domain.services.interfaces.ICarteiraService;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService implements ICarteiraService {

    private final ICarteiraRepository repository;
    private final CarteiraInputModelParaCarteira factoryEntity;
    private final CarteiraParaCarteiraViewModel factoryViewModel;

    public CarteiraService(ICarteiraRepository repository, CarteiraInputModelParaCarteira factoryEntity, CarteiraParaCarteiraViewModel factoryViewModel) {
        this.repository = repository;
        this.factoryEntity = factoryEntity;
        this.factoryViewModel = factoryViewModel;
    }

    @Override
    public CarteiraViewModel criarCarteira(CarteiraInputModel carteiraInputModel) {

        final var carteira = this.factoryEntity.create(carteiraInputModel);

        final var entity = this.repository.criar(carteira);

        return this.factoryViewModel.create(entity);
    }
}
