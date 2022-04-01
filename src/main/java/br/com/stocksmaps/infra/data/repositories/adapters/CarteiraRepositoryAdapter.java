package br.com.stocksmaps.infra.data.repositories.adapters;

import br.com.stocksmaps.core.adapter.BaseAdapter;
import br.com.stocksmaps.infra.data.models.CarteiraModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarteiraRepositoryAdapter extends BaseAdapter<CarteiraJPARepository> {

    protected CarteiraRepositoryAdapter(CarteiraJPARepository to) {
        super(to);
    }

    public CarteiraModel salvar(CarteiraModel carteiraModel) {
        return this.to.save(carteiraModel);
    }

    public Optional<CarteiraModel> buscarPorId(Long id) {
        return this.to.findById(id);
    }
}
