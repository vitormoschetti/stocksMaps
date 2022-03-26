package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
public class Ativo {

    private String codigo;
    private BigDecimal valorAtual;
    private TipoAtivoEnum tipoAtivo;
    private BigDecimal precoMedio;
    private BigDecimal quantidade;
    private LocalDateTime dataInicio;
    private LocalDateTime dataUltimaCompra;


    Ativo(TipoAtivoEnum tipoAtivo) {
        this.tipoAtivo = tipoAtivo;
    }

    public void criarAtivo(String codigo, BigDecimal valorAtual, BigDecimal quantidade){
        this.codigo = codigo;
        this.valorAtual = valorAtual;
        this.precoMedio = valorAtual;
        this.quantidade = quantidade;
        this.dataInicio = LocalDateTime.now(ZoneOffset.UTC);
        this.dataUltimaCompra = LocalDateTime.now(ZoneOffset.UTC);
    }

    //TODO adicionar ativo existente




}
