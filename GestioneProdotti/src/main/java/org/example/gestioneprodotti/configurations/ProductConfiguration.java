package org.example.gestioneprodotti.configurations;

import com.github.javafaker.Faker;
import org.example.gestioneprodotti.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

@Configuration
public class ProductConfiguration {

    @Bean("createProduct")
    @Scope("prototype")
    public Product createProduct() {
        return new Product();
    }

    @Bean("createFakeProduct")
    @Scope("prototype")
    public Product createFakeProduct() {
        Faker faker = new Faker(new Locale("it-IT"));
        return Product.builder()
                .name(faker.commerce().productName())
                .price(new BigDecimal(faker.commerce().price().replace(",", ".")))
                .createdAt(LocalDateTime.now())
                .description(faker.lorem().paragraph()).build();
    }

}
