package org.example.eserciziosettimana5.configurations;

import com.github.javafaker.Faker;
import org.example.eserciziosettimana5.models.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class CategoryConfiguration {

    @Bean("createcategory")
    @Scope("prototype")
    public Category createCategory() {
        return new Category();
    }

    @Bean("createfakecategory")
    @Scope("prototype")
    public Category createFakeCategory() {
        Faker faker = new Faker(new Locale("it-IT"));
        return Category.builder()
                .nome(faker.book().genre())
                .build();
    }

}
