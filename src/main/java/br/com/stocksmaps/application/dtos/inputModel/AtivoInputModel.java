package br.com.stocksmaps.application.dtos.inputModel;

import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AtivoInputModel {

    private String codigo;
    private TipoAtivoEnum tipoAtivo;
    private BigDecimal preco;
    private Double quantidade;
    private String dataCompra;
}
