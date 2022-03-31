package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.domain.enums.StatusEnum;
import br.com.stocksmaps.infra.data.models.CarteiraModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
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

    public Carteira(){
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

    public void adicionarAcao(Acao acao){
        //TODO não basta adicionar, tem que fazer preço medio, quantidade
        this.acoes.add(acao);
    }

    public void adicionarStock(Stock stock){
        this.stocks.add(stock);
    }

    public void adicionarFundoImobiliario(FundoImobiliario fundoImobiliario){
        this.fundosImobiliarios.add(fundoImobiliario);
    }

    public void adicionarReit(Reit reit) {
        this.reits.add(reit);
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
    }
}
