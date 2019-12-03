package net.atos.httpclient;

import lombok.extern.slf4j.Slf4j;
import net.atos.api.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
public class HttpClientApplication {

    @Bean
    public HttpInvokerProxyFactoryBean httpInvoker() {

        HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();
        factoryBean.setServiceUrl("http://localhost:8080/weatherhttp");
        factoryBean.setServiceInterface(Weather.class);
        return factoryBean;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HttpClientApplication.class, args);
        Weather weather = context.getBean(Weather.class);
        log.info("================Client Side ========================");
        List<Date> dates = Collections.singletonList(new Date());
        log.info("{}", weather.getTemperature("Warszawa", dates));
    }

}
