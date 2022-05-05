package br.com.stocksmaps.application.controllers;

import br.com.stocksmaps.application.dtos.inputModel.AtivosInputModel;
import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.application.useCases.AdicionarAtivoUseCase;
import br.com.stocksmaps.domain.entities.Carteira;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.util.function.Tuples;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/ativos")
public class AtivoController {

    private final AdicionarAtivoUseCase adicionarAtivoUseCase;

    @PostMapping("/{id}/carteira")
    public ResponseEntity<CarteiraViewModel> adicionar(@PathVariable(name = "id") Long idCarteira,
                                                       @Valid @RequestBody AtivosInputModel input) {

        final var carteira = this.adicionarAtivoUseCase.execute(Tuples.of(idCarteira, input));

        return ResponseEntity.ok().body(carteira);

    }

}
