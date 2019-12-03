package net.atos.hessianclient;

import lombok.extern.slf4j.Slf4j;
import net.atos.api.Weather;
import net.atos.rmiclient.SpringRmiClientApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
public class HessianClientApplication {

    @Bean
    public HessianProxyFactoryBean hessianInvoker() {

        HessianProxyFactoryBean factoryBean = new HessianProxyFactoryBean();
        factoryBean.setServiceUrl("http://localhost:9091/weatherhessian");
        factoryBean.setServiceInterface(Weather.class);
        return factoryBean;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HessianClientApplication.class, args);
        Weather weather = context.getBean(Weather.class);
        log.info("================Client Side ========================");
        List<Date> dates = Collections.singletonList(new Date());
        log.info("{}", weather.getTemperature("Warszawa", dates));
    }

}
