package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@NoArgsConstructor
public class Ativo {

    private String codigo;
    private BigDecimal valorAtual;
    private TipoAtivoEnum tipoAtivo;
    private BigDecimal precoMedio;
    private BigDecimal quantidade;
    private String dataInicio;
    private String dataUltimaCompra;

    public Ativo(TipoAtivoEnum tipoAtivo) {
        this.tipoAtivo = tipoAtivo;
    }

    public void criarAtivo(AtivoInputModel input) {
        this.codigo = input.getCodigo();
        this.valorAtual = input.getValorAtual();
        this.tipoAtivo = input.getTipoAtivo();
        this.precoMedio = input.getPrecoMedio();
        this.quantidade = input.getQuantidade();
        this.dataUltimaCompra = input.getDataCompra();
    }

    //TODO adicionar ativo existente




}
