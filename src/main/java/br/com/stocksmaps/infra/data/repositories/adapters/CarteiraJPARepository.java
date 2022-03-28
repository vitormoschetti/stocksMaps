package br.com.stocksmaps.infra.data.repositories.adapters;


import br.com.stocksmaps.infra.data.models.CarteiraModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraJPARepository extends JpaRepository<CarteiraModel, Long> {
}
