package br.com.stocksmaps.application.dtos.inputModel;

import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AtivoInputModel {

    private String codigo;
    private BigDecimal valorAtual;
    private TipoAtivoEnum tipoAtivo;
    private BigDecimal precoMedio;
    private BigDecimal quantidade;
    private String dataCompra;
    private String segmento;
}
