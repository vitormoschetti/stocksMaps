package br.com.stocksmaps.infra.adapters.yahooFinance;

import br.com.stocksmaps.application.dtos.YahooFinanceDTO;
import br.com.stocksmaps.core.httpClient.BaseFeign;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.stereotype.Component;

@Component
public class YahooFinanceHttpClient extends BaseFeign<IYahooFinanceClient> {

    public YahooFinanceHttpClient(
            @Value("${http.yahoofinance}") final String host,
            final ResponseEntityDecoder decoder,
            final Encoder encoder,
            final YahooFinanceRequestInterceptor requestInterceptor) {

        super(host, IYahooFinanceClient.class, decoder, encoder, requestInterceptor);
    }

    public YahooFinanceDTO obterAtivo(String codigo) {
        final var response = this.client.obterAtivo(codigo);
        System.out.println(response.getBody());
        return response.getBody();
    }
}
