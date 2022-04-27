package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.domain.enums.StatusEnum;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import br.com.stocksmaps.domain.pattern.AcaoFactory;
import br.com.stocksmaps.domain.pattern.FundoImobiliarioFactory;
import br.com.stocksmaps.domain.pattern.ReitFactory;
import br.com.stocksmaps.domain.pattern.StockFactory;
import br.com.stocksmaps.infra.adapters.HGBrasilHttpClient;
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
    private List<Reit> reits;
    private List<FundoImobiliario> fundosImobiliarios;
    private BigDecimal totalInvestido;
    private BigDecimal totalAtual;
    private StatusEnum status;

    public Carteira() {
        acoes = new ArrayList<>();
        stocks = new ArrayList<>();
        reits = new ArrayList<>();
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

    public List<Reit> getReits() {
        return Collections.unmodifiableList(reits);
    }

    public void criarNovo(CarteiraInputModel inputModel) {
        this.nome = inputModel.getNome();
        this.status = StatusEnum.ATIVA;
        this.totalAtual = BigDecimal.ZERO;
        this.totalInvestido = BigDecimal.ZERO;
    }

    public void fromModel(CarteiraModel carteiraModel) {
        this.id = carteiraModel.getId();
        this.nome = carteiraModel.getNome();
        this.totalInvestido = carteiraModel.getTotalInvestido();
        this.totalAtual = carteiraModel.getTotalAtual();
        this.status = StatusEnum.find(carteiraModel.getStatus());

        //TODO regra de transformar ativos em entidades.
    }

    public void adicionar(List<Ativo> ativos) {

        ativos.forEach(ativo -> {

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.ACAO))
                this.adicionarAcao(ativo);

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.FUNDO_IMOBILIARIO))
                this.adicionarFundoImobiliario(ativo);

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.REIT))
                this.adicionarReit(ativo);

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

    private void adicionarReit(Ativo input) {
        final var reit = new ReitFactory().create(input);

        final var optionalReit = this.getReits().stream()
                .filter(ativo -> ativo.getCodigo().equalsIgnoreCase(input.getCodigo()))
                .findFirst();

        if (optionalReit.isEmpty()) {
            this.reits.add(reit);
        } else {
            final var reitCarteira = optionalReit.get();
            reitCarteira.adicionar(reit);
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


    public void calcularValorTotal() {


    }
}
