package br.com.stocksmaps.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class YahooFinanceDTO {

    @JsonProperty("quoteResponse")
    private YahooFinanceResponseDTO quoteResponse;

}
