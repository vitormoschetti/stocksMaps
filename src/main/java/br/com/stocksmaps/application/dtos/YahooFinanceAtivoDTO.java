package br.com.stocksmaps.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class YahooFinanceAtivoDTO {

    @JsonProperty("regularMarketPrice")
    private BigDecimal precoAtual;

}
