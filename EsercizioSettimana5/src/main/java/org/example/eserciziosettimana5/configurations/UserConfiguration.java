package org.example.eserciziosettimana5.configurations;

import com.github.javafaker.Faker;
import org.example.eserciziosettimana5.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class UserConfiguration {

    @Bean("createuser")
    @Scope("prototype")
    public User createUser() {
        return new User();
    }

    @Bean("createfakeuser")
    @Scope("prototype")
    public User createFakeUser() {
        Faker faker = new Faker(new Locale("it-IT"));
        return User.builder()
                .nome(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .telefono(faker.phoneNumber().cellPhone())
                .build();
    }

}
