package br.com.stocksmaps.infra.adapters.yahooFinance;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class YahooFinanceRequestInterceptor implements RequestInterceptor {

    private final String hostHeader;
    private final String host;

    private final String keyHeader;
    private final String key;

    public YahooFinanceRequestInterceptor(
            @Value("${http.yahoofinance.api-host-header}") String hostHeader,
            @Value("${http.yahoofinance.api-host}") String host,
            @Value("${http.yahoofinance.api-key-header}") String keyHeader,
            @Value("${http.yahoofinance.api-key}") String key) {
        this.hostHeader = hostHeader;
        this.host = host;
        this.keyHeader = keyHeader;
        this.key = key;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {

        requestTemplate
                .header(hostHeader, host)
                .header(keyHeader, key)
                .query("region", "BR");

    }
}
