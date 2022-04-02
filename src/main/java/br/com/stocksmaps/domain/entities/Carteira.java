package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.domain.enums.StatusEnum;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import br.com.stocksmaps.domain.pattern.AcaoFactory;
import br.com.stocksmaps.domain.pattern.FundoImobiliarioFactory;
import br.com.stocksmaps.domain.pattern.ReitFactory;
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

        //TODO regra de transformar ativos em entidades.
    }

    public void adicionar(List<Ativo> ativos) {

        ativos.forEach(ativo -> {

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.ACAO))
                this.acoes.add(new AcaoFactory().create(ativo));

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.FUNDO_IMOBILIARIO))
                this.fundosImobiliarios.add(new FundoImobiliarioFactory().create(ativo));

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.REIT))
                this.reits.add(new ReitFactory().create(ativo));

            if (ativo.getTipoAtivo().equals(TipoAtivoEnum.STOCK))
                this.stocks.add(new StockFactory().create(ativo));
        });

    }
}
