package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import br.com.stocksmaps.infra.data.models.AtivoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@NoArgsConstructor
public abstract class Ativo {

    private Long id;
    private String codigo;
    private TipoAtivoEnum tipoAtivo;
    private BigDecimal precoMedio;
    private BigDecimal quantidade;
    private String dataUltimaCompra;
    private BigDecimal precoAtual;
    private BigDecimal variacao;

    private BigDecimal totalInvestido;

    private BigDecimal totalAtual;

    public void criarNovo(AtivoInputModel input) {
        mapearCampos(null, input.getCodigo(), input.getTipoAtivo(), input.getPreco(), input.getQuantidade(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    public void criar(AtivoModel input) {
        mapearCampos(input.getId(), input.getCodigo(), input.getTipoAtivo(), input.getPrecoMedio(), input.getQuantidade(), input.getPrecoAtual(), input.getVariacao(), input.getTotalInvestido(), input.getTotalAtual());
    }

    public void criar(Ativo input) {
        mapearCampos(input.getId(), input.getCodigo(), input.getTipoAtivo(), input.getPrecoMedio(), input.getQuantidade(), input.getPrecoAtual(), input.getVariacao(), input.getTotalInvestido(), input.getTotalAtual());
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

    protected void adicionar(Ativo ativo) {
        this.fazerPrecoMedio(ativo.getPrecoMedio(), ativo.getQuantidade());
        this.adicionarQuantidade(ativo.getQuantidade());
        this.atualizarDataCompra(ativo.getDataUltimaCompra());
    }

    private void adicionarQuantidade(BigDecimal quantidade) {
        this.quantidade = this.quantidade.add(quantidade);
    }

    private void atualizarDataCompra(String dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }

    private void fazerPrecoMedio(BigDecimal precoMedio, BigDecimal quantidade) {
        this.precoMedio = (this.totalAtivo(this.precoMedio, this.quantidade).add(this.totalAtivo(precoMedio, quantidade))).divide(this.quantidade.add(quantidade), 2, RoundingMode.HALF_UP);
    }

    private BigDecimal totalAtivo(BigDecimal precoMedio, BigDecimal quantidade) {
        return precoMedio.multiply(quantidade);
    }

    protected void atualizarPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
        this.totalAtual = this.totalAtivo(this.precoAtual, this.quantidade).setScale(2, RoundingMode.HALF_UP);
        this.totalInvestido = this.totalAtivo(this.precoMedio, this.quantidade).setScale(2, RoundingMode.HALF_UP);
        this.variacao = (this.precoAtual.divide(this.precoMedio, 3, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(100));
    }


    //TODO adicionar ativo existente


}
