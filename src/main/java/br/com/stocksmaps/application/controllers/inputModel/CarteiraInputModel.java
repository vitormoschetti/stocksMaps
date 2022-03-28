package br.com.stocksmaps.application.controllers.inputModel;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CarteiraInputModel {

    @NotBlank
    @Size(min = 5, max = 20)
    private String nome;

}
