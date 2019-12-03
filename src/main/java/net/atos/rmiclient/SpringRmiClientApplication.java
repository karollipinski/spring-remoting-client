package net.atos.rmiclient;

import lombok.extern.slf4j.Slf4j;
import net.atos.api.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringRmiClientApplication {

    @Bean
    RmiProxyFactoryBean rmiProxy() {
        RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
        bean.setServiceInterface(Weather.class);
        bean.setServiceUrl("rmi://localhost:1099/weatherrmi");

        return bean;
    }

    public static void main(String[] args) {
        Weather weatherRMI = SpringApplication.run(SpringRmiClientApplication.class, args)
                                              .getBean(Weather.class);
        log.info("================Client Side ========================");
        List<Date> dates = Collections.singletonList(new Date());
        log.info("{}", weatherRMI.getTemperature("Warszawa", dates));
    }
}
