package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.domain.enums.StatusCarteiraEnum;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import br.com.stocksmaps.domain.pattern.AcaoFactory;
import br.com.stocksmaps.domain.pattern.FundoImobiliarioFactory;
import br.com.stocksmaps.domain.pattern.StockFactory;
import br.com.stocksmaps.infra.data.models.CarteiraModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@ToString
@Setter(AccessLevel.PRIVATE)
public class Carteira {

    private Long id;
    private String nome;
    private List<Acao> acoes;
    private List<Stock> stocks;
    private List<FundoImobiliario> fundosImobiliarios;
    private BigDecimal totalInvestido;
    private BigDecimal totalAtual;
    private StatusCarteiraEnum status;

    public Carteira() {
        acoes = new ArrayList<>();
        stocks = new ArrayList<>();
        fundosImobiliarios = new ArrayList<>();
    }

    public List<Acao> getAcoes() {
        return Collections.unmodifiableList(acoes);
    }

    public List<Stock> getStocks() {
        return Collections.unmodifiableList(stocks);
    }

    public List<FundoImobiliario> getFundosImobiliarios() {
        return Collections.unmodifiableList(fundosImobiliarios);
    }

    public void criarNovo(CarteiraInputModel inputModel) {
        this.nome = inputModel.getNome();
        this.status = StatusCarteiraEnum.ATIVA;
        this.totalAtual = BigDecimal.ZERO;
        this.totalInvestido = BigDecimal.ZERO;
    }

    public void fromModel(CarteiraModel carteiraModel) {
        this.id = carteiraModel.getId();
        this.nome = carteiraModel.getNome();
        this.totalInvestido = carteiraModel.getTotalInvestido();
        this.totalAtual = carteiraModel.getTotalAtual();
        this.status = StatusCarteiraEnum.find(carteiraModel.getStatus());

        //TODO regra de transformar ativos em entidades.
    }

    public void adicionar(List<Ativo> ativos) {

        ativos.forEach(ativo -> {

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.ACAO))
                this.adicionarAcao(ativo);

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.FUNDO_IMOBILIARIO))
                this.adicionarFundoImobiliario(ativo);

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.STOCK))
                this.adicionarStock(ativo);
        });

    }

    private void adicionarStock(Ativo input) {
        final var stock = new StockFactory().create(input);

        final var optionalStock = this.getStocks().stream()
                .filter(ativo -> ativo.getCodigo().equalsIgnoreCase(input.getCodigo()))
                .findFirst();

        if (optionalStock.isEmpty()) {
            this.stocks.add(stock);
        } else {
            final var stockCarteira = optionalStock.get();
            stockCarteira.adicionar(stock);
        }


    }

    private void adicionarFundoImobiliario(Ativo input) {
        final var fundoImobiliario = new FundoImobiliarioFactory().create(input);

        final var optionalFundoImobiliario = this.getFundosImobiliarios().stream()
                .filter(ativo -> ativo.getCodigo().equalsIgnoreCase(input.getCodigo()))
                .findFirst();

        if (optionalFundoImobiliario.isEmpty()) {
            this.fundosImobiliarios.add(fundoImobiliario);
        } else {
            final var fiiCarteira = optionalFundoImobiliario.get();
            fiiCarteira.adicionar(fundoImobiliario);
        }

    }

    private void adicionarAcao(Ativo input) {
        final var acao = new AcaoFactory().create(input);

        final var optionalAcao = this.getAcoes().stream()
                .filter(ativo -> ativo.getCodigo().equalsIgnoreCase(input.getCodigo()))
                .findFirst();

        if (optionalAcao.isEmpty()) {
            this.acoes.add(acao);
        } else {
            final var acaoCarteira = optionalAcao.get();
            acaoCarteira.adicionar(acao);
        }
    }

}
