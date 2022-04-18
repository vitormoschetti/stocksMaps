package br.com.stocksmaps.application.dtos.inputModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class AutenticacaoChaveHGBrasilInputModel {

    @JsonProperty("valid_key")
    private Boolean valid;

}
