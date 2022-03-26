package br.com.stocksmaps.infra.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CarteiraModel.TABLE_NAME)
public class CarteiraModel implements Serializable {

    public static final String TABLE_NAME = "carteira";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_" + TABLE_NAME)
    @SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    @JoinColumn(name = "carteira_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<AtivoModel> ativos;

    @Column(name = "totalInvestido")
    private BigDecimal totalInvestido;

    @Column(name = "totalAtual")
    private BigDecimal totalAtual;

}
