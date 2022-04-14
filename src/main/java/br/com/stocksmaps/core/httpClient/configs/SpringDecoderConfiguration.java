package br.com.stocksmaps.core.httpClient.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SpringDecoderConfiguration {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    ObjectFactory<HttpMessageConverters> converters;

    @Autowired
    ObjectProvider<HttpMessageConverterCustomizer> customizers;

    @Bean
    public ResponseEntityDecoder responseEntityDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(this.converters, this.customizers));
    }

    @Bean
    public Encoder feignEncoder() {
        return new PageableSpringEncoder(new SpringEncoder(this.converters));
    }

}
