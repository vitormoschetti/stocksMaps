package br.com.stocksmaps.application.controllers;

import br.com.stocksmaps.application.dtos.inputModel.AtivosInputModel;
import br.com.stocksmaps.application.useCases.AdicionarAtivoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.util.function.Tuples;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/ativos")
public class AtivoController {

    private final AdicionarAtivoUseCase adicionarAtivoUseCase;

    @PostMapping("/{id}/carteira")
    public void adicionar(@PathVariable(name = "id") Long idCarteira,
                          @Valid @RequestBody AtivosInputModel input) {

        this.adicionarAtivoUseCase.execute(Tuples.of(idCarteira, input));


    }

}
