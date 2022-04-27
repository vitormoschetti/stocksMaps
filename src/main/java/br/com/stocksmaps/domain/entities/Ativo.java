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

    public void criarNovo(AtivoInputModel input) {
        this.codigo = input.getCodigo();
        this.tipoAtivo = input.getTipoAtivo();
        this.precoMedio = input.getPreco();
        this.quantidade = input.getQuantidade();
        this.dataUltimaCompra = input.getDataCompra();
    }

    public void criar(AtivoModel input) {
        this.id = input.getId();
        this.codigo = input.getCodigo();
        this.tipoAtivo = input.getTipoAtivo();
        this.precoMedio = input.getPrecoMedio();
        this.quantidade = input.getQuantidade();
        this.dataUltimaCompra = input.getDataUltimaCompra();
    }

    public void criar(Ativo input) {
        this.id = input.getId();
        this.codigo = input.getCodigo();
        this.tipoAtivo = input.getTipoAtivo();
        this.precoMedio = input.getPrecoMedio();
        this.quantidade = input.getQuantidade();
        this.dataUltimaCompra = input.getDataUltimaCompra();
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
        this.variacao = (this.precoAtual.divide(this.precoMedio, 3, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(100));
    }


    //TODO adicionar ativo existente


}
