package org.example.gestioneprodotti.configurations;

import com.github.javafaker.Faker;
import org.example.gestioneprodotti.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.util.Locale;

@Configuration
public class UserConfiguration {

    @Bean("createUser")
    @Scope("prototype")
    public User createUser() {
        return new User();
    }

    @Bean("createFakeUser")
    @Scope("prototype")
    public User createFakeUser() {
        Faker faker = new Faker(new Locale("it-IT"));
        return User.builder()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .createdAt(LocalDateTime.now())
                .build();
    }

}
