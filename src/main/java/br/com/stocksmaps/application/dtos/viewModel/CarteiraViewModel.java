package br.com.stocksmaps.application.dtos.viewModel;

import br.com.stocksmaps.domain.entities.Carteira;
import lombok.Getter;

@Getter
public class CarteiraViewModel {

    private Long id;
    private String nome;

    public CarteiraViewModel(Carteira carteira) {
        this.id = carteira.getId();
        this.nome = carteira.getNome();
    }
}
