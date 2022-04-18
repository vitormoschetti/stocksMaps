package br.com.stocksmaps.application.dtos.inputModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class FinancaInputModel {
    @JsonProperty("results")
    private ResultadoFinancaInputModel resultados;
}

@Getter
@ToString
@NoArgsConstructor
class ResultadoFinancaInputModel {

    @JsonProperty("currencies")
    private MoedasInputModel moedas;

    @JsonProperty("stocks")
    private IndicesInputModel indice;

    @JsonProperty("taxes")
    private List<SelicInputModel> selic;
}

@Getter
@ToString
@NoArgsConstructor
class SelicInputModel {

    @JsonProperty("date")
    private String data;

    @JsonProperty("selic")
    private Double selic;

}

@Getter
@ToString
@NoArgsConstructor
class IndicesInputModel {

    @JsonProperty("IBOVESPA")
    private IndexInputModel ibovespa;

    @JsonProperty("IFIX")
    private IndexInputModel ifix;

}

@Getter
@ToString
@NoArgsConstructor
class IndexInputModel{

    @JsonProperty("name")
    private String nome;

    @JsonProperty("points")
    private BigDecimal pontos;

}


@Getter
@ToString
@NoArgsConstructor
class MoedasInputModel {
    @JsonProperty("USD")
    private CambioInputModel dollar;
}

@Getter
@ToString
@NoArgsConstructor
class CambioInputModel {
    @JsonProperty("name")
    private String nome;

    @JsonProperty("buy")
    private BigDecimal compra;

    @JsonProperty("sell")
    private BigDecimal venda;
}
