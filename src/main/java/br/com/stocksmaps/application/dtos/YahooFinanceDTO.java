package br.com.stocksmaps.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class YahooFinanceDTO {

    @JsonProperty("quoteResponse")
    private YahooFinanceResponseDTO response;

}
