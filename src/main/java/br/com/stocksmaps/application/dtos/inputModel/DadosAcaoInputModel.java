package br.com.stocksmaps.application.dtos.inputModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@NoArgsConstructor
public class DadosAcaoInputModel {

    @JsonProperty("symbol")
    private String codigo;

    @JsonProperty("name")
    private String nome;

    @JsonProperty("website")
    private String siteRI;

    @JsonProperty("price")
    private BigDecimal precoAtual;

}