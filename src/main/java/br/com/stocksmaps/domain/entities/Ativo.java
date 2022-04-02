package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public abstract class Ativo {

    private String codigo;
    private BigDecimal valorAtual;
    private TipoAtivoEnum tipoAtivo;
    private BigDecimal preco;
    private BigDecimal quantidade;
    private String dataInicio;
    private String dataUltimaCompra;

    public void criar(AtivoInputModel input) {
        this.codigo = input.getCodigo();
        this.valorAtual = input.getValorAtual();
        this.tipoAtivo = input.getTipoAtivo();
        this.preco = input.getPreco();
        this.quantidade = input.getQuantidade();
        this.dataUltimaCompra = input.getDataCompra();
    }

    protected void criar(Ativo input) {
        this.codigo = input.getCodigo();
        this.valorAtual = input.getValorAtual();
        this.tipoAtivo = input.getTipoAtivo();
        this.preco = input.getPreco();
        this.quantidade = input.getQuantidade();
        this.dataUltimaCompra = input.getDataUltimaCompra();
    }

    protected abstract void validar();

    //TODO adicionar ativo existente


}
