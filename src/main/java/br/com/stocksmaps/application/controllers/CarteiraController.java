package br.com.stocksmaps.application.controllers;

import br.com.stocksmaps.application.controllers.inputModel.CarteiraInputModel;
import br.com.stocksmaps.application.useCases.CriarCarteiraUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/carteiras")
public class CarteiraController {

    private final CriarCarteiraUseCase criarCarteiraUseCase;

    @PostMapping
    public void criar(@Valid @RequestBody CarteiraInputModel input) {

        //TODO construir factories e retorno da api
        final var response = this.criarCarteiraUseCase.execute(input);

    }


}
