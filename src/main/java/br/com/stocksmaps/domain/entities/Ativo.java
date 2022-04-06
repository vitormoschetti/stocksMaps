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
    private BigDecimal preco;
    private BigDecimal quantidade;
    private String dataUltimaCompra;

    public void criarNovo(AtivoInputModel input) {
        this.codigo = input.getCodigo();
        this.tipoAtivo = input.getTipoAtivo();
        this.preco = input.getPreco();
        this.quantidade = input.getQuantidade();
        this.dataUltimaCompra = input.getDataCompra();
    }

    public void criar(AtivoModel input) {
        this.id = input.getId();
        this.codigo = input.getCodigo();
        this.tipoAtivo = input.getTipoAtivo();
        this.preco = input.getPreco();
        this.quantidade = input.getQuantidade();
        this.dataUltimaCompra = input.getDataUltimaCompra();
    }

    public void criar(Ativo input) {
        this.id = input.getId();
        this.codigo = input.getCodigo();
        this.tipoAtivo = input.getTipoAtivo();
        this.preco = input.getPreco();
        this.quantidade = input.getQuantidade();
        this.dataUltimaCompra = input.getDataUltimaCompra();
        validar();
    }

    protected abstract void validar();

    protected void adicionar(Ativo ativo) {
        this.fazerPrecoMedio(ativo.getPreco(), ativo.getQuantidade());
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
        this.preco = (this.totalAtivo(this.preco, this.quantidade).add(this.totalAtivo(precoMedio, quantidade))).divide(this.quantidade.add(quantidade), 2, RoundingMode.HALF_UP);
    }

    private BigDecimal totalAtivo(BigDecimal precoMedio, BigDecimal quantidade) {
        return precoMedio.multiply(quantidade);
    }


    //TODO adicionar ativo existente


}
