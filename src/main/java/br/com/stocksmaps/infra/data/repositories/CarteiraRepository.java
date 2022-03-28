package br.com.stocksmaps.infra.data.repositories;

import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.domain.repositories.ICarteiraRepository;
import br.com.stocksmaps.infra.data.factories.CarteiraModelParaCarteira;
import br.com.stocksmaps.infra.data.factories.CarteiraParaCarteiraModelFactory;
import br.com.stocksmaps.infra.data.repositories.adapters.CarteiraRepositoryAdapter;
import org.springframework.stereotype.Repository;

@Repository
public class CarteiraRepository implements ICarteiraRepository {

    private final CarteiraRepositoryAdapter adapter;
    private final CarteiraParaCarteiraModelFactory factoryModel;
    private final CarteiraModelParaCarteira factoryEntity;

    public CarteiraRepository(CarteiraRepositoryAdapter carteiraRepositoryAdapter, CarteiraParaCarteiraModelFactory factoryModel, CarteiraModelParaCarteira factoryEntity) {
        this.adapter = carteiraRepositoryAdapter;
        this.factoryModel = factoryModel;
        this.factoryEntity = factoryEntity;
    }

    @Override
    public Carteira salvar(Carteira carteira) {
        final var carteiraModel = factoryModel.create(carteira);
        final var model = adapter.salvar(carteiraModel);
        return factoryEntity.create(model);
    }
}
