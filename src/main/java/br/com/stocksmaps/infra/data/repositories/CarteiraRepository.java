package br.com.stocksmaps.infra.data.repositories;

import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.domain.repositories.ICarteiraRepository;
import br.com.stocksmaps.infra.data.factories.CarteiraModelParaCarteira;
import br.com.stocksmaps.infra.data.factories.CarteiraParaCarteiraModelFactory;
import br.com.stocksmaps.infra.data.models.CarteiraModel;
import br.com.stocksmaps.infra.data.repositories.adapters.CarteiraRepositoryAdapter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public Carteira criar(Carteira carteira) {

        final var carteiraModel = this.factoryModel.create(carteira);

        final var model = this.adapter.salvar(carteiraModel);
        return this.factoryEntity.create(model);
    }

    @Override
    public Carteira buscarPorId(Long id) {

        final var optionalCarteiraModel = this.adapter.buscarPorId(id);

        if(optionalCarteiraModel.isEmpty())
            return null;

        return factoryEntity.create(optionalCarteiraModel.get());
    }

    @Override
    public Void atualizar(Carteira carteira) {

        final var carteiraModel = this.factoryModel.create(carteira);

        this.adapter.salvar(carteiraModel);

        carteira = factoryEntity.create(carteiraModel);

        return null;
    }
}
