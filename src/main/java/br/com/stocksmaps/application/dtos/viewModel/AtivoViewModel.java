package br.com.stocksmaps.application.dtos.viewModel;

import br.com.stocksmaps.domain.entities.Ativo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class AtivoViewModel<T extends Ativo> {

    private String codigo;
    private BigDecimal precoMedio;
    private BigDecimal quantidade;
    private BigDecimal precoAtual;
    private BigDecimal variacao;
    private BigDecimal totalInvestido;
    private BigDecimal totalAtual;

    public List<AtivoViewModel> converter(final List<T> ativos) {
        return ativos.stream().map(AtivoViewModel::new).collect(Collectors.toList());
    }

    private AtivoViewModel(T ativo) {
        this.codigo = ativo.getCodigo();
        this.precoMedio = ativo.getPrecoMedio();
        this.quantidade = ativo.getQuantidade();
        this.precoAtual = ativo.getPrecoAtual();
        this.variacao = ativo.getVariacao();
        this.totalInvestido = ativo.getTotalInvestido();
        this.totalAtual = ativo.getTotalAtual();
    }


}
