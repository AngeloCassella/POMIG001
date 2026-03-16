package org.example.eserciziosettimana5.configurations;

import com.github.javafaker.Faker;
import org.example.eserciziosettimana5.models.Author;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class AuthorConfiguration {

    @Bean("createauthor")
    @Scope("prototype")
    public Author createAuthor() {
        return new Author();
    }

    @Bean("createfakeauthor")
    @Scope("prototype")
    public Author createFakeAuthor() {
        Faker faker = new Faker(new Locale("it-IT"));
        return Author.builder()
                .nome(faker.name().fullName())
                .nazionalita(faker.nation().nationality())
                .build();
    }

}
