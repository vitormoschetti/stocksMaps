package br.com.stocksmaps.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class YahooFinanceResultado {

    @JsonProperty("regularMarketPrice")
    private BigDecimal precoAtual;

}
