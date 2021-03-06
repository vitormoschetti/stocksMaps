package br.com.stocksmaps.infra.data.models;

import br.com.stocksmaps.core.IEntity;
import br.com.stocksmaps.domain.entities.Acao;
import br.com.stocksmaps.domain.entities.FundoImobiliario;
import br.com.stocksmaps.domain.entities.Stock;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = AtivoModel.TABLE_NAME)
public class AtivoModel implements Serializable, IEntity {

    public static final String TABLE_NAME = "ativo";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_" + TABLE_NAME)
    @SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "codigo", nullable = false, length = 6)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoAtivo", nullable = false)
    private TipoAtivoEnum tipoAtivo;

    @Column(name = "precoMedio", nullable = false)
    private BigDecimal precoMedio;

    @Column(name = "quantidade", nullable = false)
    private BigDecimal quantidade;

    @Column(name = "precoAtual")
    private BigDecimal precoAtual;

    @Column(name = "variacao")
    private BigDecimal variacao;

    @Column(name = "totalInvestido")
    private BigDecimal totalInvestido;

    @Column(name = "totalAtual")
    private BigDecimal totalAtual;

    public AtivoModel(Acao ativo) {
        mapearCampos(ativo.getId(), ativo.getCodigo(), ativo.getTipoAtivo(), ativo.getPrecoMedio(), ativo.getQuantidade(), ativo.getPrecoAtual(), ativo.getVariacao(), ativo.getTotalInvestido(), ativo.getTotalAtual());
    }

    public AtivoModel(FundoImobiliario ativo) {
        mapearCampos(ativo.getId(), ativo.getCodigo(), ativo.getTipoAtivo(), ativo.getPrecoMedio(), ativo.getQuantidade(), ativo.getPrecoAtual(), ativo.getVariacao(), ativo.getTotalInvestido(), ativo.getTotalAtual());
    }

    public AtivoModel(Stock ativo) {
        mapearCampos(ativo.getId(), ativo.getCodigo(), ativo.getTipoAtivo(), ativo.getPrecoMedio(), ativo.getQuantidade(), ativo.getPrecoAtual(), ativo.getVariacao(), ativo.getTotalInvestido(), ativo.getTotalAtual());
    }

    private void mapearCampos(Long id, String codigo, TipoAtivoEnum tipoAtivo, BigDecimal precoMedio, BigDecimal quantidade, BigDecimal precoAtual, BigDecimal variacao, BigDecimal totalInvestido, BigDecimal totalAtual) {
        this.id = id;
        this.codigo = codigo;
        this.tipoAtivo = tipoAtivo;
        this.precoMedio = precoMedio;
        this.quantidade = quantidade;
        this.precoAtual = precoAtual;
        this.variacao = variacao;
        this.totalInvestido = totalInvestido;
        this.totalAtual = totalAtual;
    }

}
