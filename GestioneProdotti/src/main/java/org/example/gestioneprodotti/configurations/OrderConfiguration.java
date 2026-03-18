package org.example.gestioneprodotti.configurations;

import org.example.gestioneprodotti.models.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class OrderConfiguration {

    @Bean("createOrder")
    @Scope("prototype")
    public Order createOrder() {
        return new Order();
    }

}
