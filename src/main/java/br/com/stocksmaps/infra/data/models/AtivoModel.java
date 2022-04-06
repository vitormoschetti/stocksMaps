package br.com.stocksmaps.infra.data.models;

import br.com.stocksmaps.core.IEntity;
import br.com.stocksmaps.domain.entities.Acao;
import br.com.stocksmaps.domain.entities.FundoImobiliario;
import br.com.stocksmaps.domain.entities.Reit;
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

    @Column(name = "codigo", nullable = false, length = 5)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoAtivo", nullable = false)
    private TipoAtivoEnum tipoAtivo;

    @Column(name = "precoMedio", nullable = false)
    private BigDecimal preco;

    @Column(name = "quantidade", nullable = false)
    private Double quantidade;

    @Column(name = "dataUltimaCompra", nullable = false)
    private String dataUltimaCompra;

    public AtivoModel(Acao ativo) {
        this.id = ativo.getId();
        this.codigo = ativo.getCodigo();
        this.tipoAtivo = ativo.getTipoAtivo();
        this.preco = ativo.getPreco();
        this.quantidade = ativo.getQuantidade();
        this.dataUltimaCompra = ativo.getDataUltimaCompra();
    }

    public AtivoModel(FundoImobiliario ativo) {
        this.id = ativo.getId();
        this.codigo = ativo.getCodigo();
        this.tipoAtivo = ativo.getTipoAtivo();
        this.preco = ativo.getPreco();
        this.quantidade = ativo.getQuantidade();
        this.dataUltimaCompra = ativo.getDataUltimaCompra();
    }

    public AtivoModel(Reit ativo) {
        this.id = ativo.getId();
        this.codigo = ativo.getCodigo();
        this.tipoAtivo = ativo.getTipoAtivo();
        this.preco = ativo.getPreco();
        this.quantidade = ativo.getQuantidade();
        this.dataUltimaCompra = ativo.getDataUltimaCompra();
    }

    public AtivoModel(Stock ativo) {
        this.id = ativo.getId();
        this.codigo = ativo.getCodigo();
        this.tipoAtivo = ativo.getTipoAtivo();
        this.preco = ativo.getPreco();
        this.quantidade = ativo.getQuantidade();
        this.dataUltimaCompra = ativo.getDataUltimaCompra();
    }

}
