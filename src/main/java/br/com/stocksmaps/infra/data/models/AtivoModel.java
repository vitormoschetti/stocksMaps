package br.com.stocksmaps.infra.data.models;

import br.com.stocksmaps.core.IEntity;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Column(name = "valorAtual", nullable = false)
    private BigDecimal valorAtual;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoAtivo", nullable = false)
    private TipoAtivoEnum tipoAtivo;

    @Column(name = "precoMedio", nullable = false)
    private BigDecimal precoMedio;

    @Column(name = "quantidade", nullable = false)
    private BigDecimal quantidade;

    @Column(name = "dataInicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "dataUltimaCompra", nullable = false)
    private LocalDateTime dataUltimaCompra;

    @Column(name = "segmento", nullable = false, length = 20)
    private String segmento;


}
