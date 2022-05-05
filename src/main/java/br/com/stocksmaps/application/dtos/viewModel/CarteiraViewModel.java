package br.com.stocksmaps.application.dtos.viewModel;

import br.com.stocksmaps.domain.entities.Carteira;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class CarteiraViewModel {

    private final Long id;
    private final String nome;
    private final BigDecimal totalAtual;
    private final BigDecimal totalInvestido;
    private final List<AtivoViewModel> acoes;
    private final List<AtivoViewModel> stocks;
    private final List<AtivoViewModel> fundosImobiliarios;

    public CarteiraViewModel(final Carteira carteira, List acoes, List stocks, List fiis) {
        this.id = carteira.getId();
        this.nome = carteira.getNome();
        this.acoes = acoes;
        this.stocks = stocks;
        this.fundosImobiliarios = fiis;
        this.totalInvestido = carteira.getTotalInvestido();
        this.totalAtual = carteira.getTotalAtual();
    }
}
