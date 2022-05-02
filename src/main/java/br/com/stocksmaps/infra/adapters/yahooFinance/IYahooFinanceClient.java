package br.com.stocksmaps.infra.adapters.yahooFinance;

import br.com.stocksmaps.application.dtos.YahooFinanceDTO;
import br.com.stocksmaps.core.httpClient.interfaces.IHttpClient;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IYahooFinanceClient extends IHttpClient {
    @GetMapping
    RequestEntity<YahooFinanceDTO> obterAtivo(@RequestParam(name = "symbols") String codigo);
}
