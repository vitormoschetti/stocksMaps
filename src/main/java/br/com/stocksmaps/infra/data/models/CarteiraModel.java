package br.com.stocksmaps.infra.data.models;

import br.com.stocksmaps.core.IEntity;
import br.com.stocksmaps.domain.entities.Carteira;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CarteiraModel.TABLE_NAME)
public class CarteiraModel implements Serializable, IEntity {

    public static final String TABLE_NAME = "carteira";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_" + TABLE_NAME)
    @SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String nome;

    @JoinColumn(name = "carteira_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AtivoModel> ativos;

    @Column(name = "totalInvestido")
    private BigDecimal totalInvestido;

    @Column(name = "totalAtual")
    private BigDecimal totalAtual;

    private Character status;

    private BigDecimal variacao;

    public void criarNovo(Carteira carteira) {
        ativos = new ArrayList<>();
        this.id = carteira.getId();
        this.nome = carteira.getNome();
        this.totalInvestido = carteira.getTotalInvestido();
        this.totalAtual = carteira.getTotalAtual();
        this.status = carteira.getStatus().getValue();
        this.transformarEmAtivos(carteira);
    }

    private void transformarEmAtivos(Carteira carteira) {

        final var acoes = carteira.getAcoes().stream().map(AtivoModel::new
        ).collect(Collectors.toList());

        final var fiis = carteira.getFundosImobiliarios().stream().map(AtivoModel::new
        ).collect(Collectors.toList());

        final var reits = carteira.getReits().stream().map(AtivoModel::new
        ).collect(Collectors.toList());

        final var stocks = carteira.getStocks().stream().map(AtivoModel::new
        ).collect(Collectors.toList());

        this.ativos.addAll(acoes);
        this.ativos.addAll(fiis);
        this.ativos.addAll(reits);
        this.ativos.addAll(stocks);

        this.calcularValorTotal();

    }

    private void calcularValorTotal() {
        this.totalAtual = totalAtual();
        this.totalInvestido = totalInvestido();
        this.variacao = variacaoCarteira();
    }

    private BigDecimal variacaoCarteira() {
        return (this.totalAtual.divide(this.totalInvestido, 3, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(100));
    }

    private BigDecimal totalInvestido() {
        return this.getAtivos().stream()
                .map(ativo -> ativo.getPrecoMedio().multiply(ativo.getQuantidade()))
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2);
    }

    private BigDecimal totalAtual() {
        return this.getAtivos().stream()
                .map(ativo -> ativo.getPrecoAtual().multiply(ativo.getQuantidade()))
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2);
    }


}
