package org.example.springwebmvc.configurations;

import com.github.javafaker.Faker;
import org.example.springwebmvc.models.User;
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
        Faker fake = new Faker(new Locale("it-IT"));
        return User.builder()
                .firstname(fake.name().firstName())
                .lastname(fake.name().lastName())
                .city(fake.address().cityName())
                .email(fake.internet().emailAddress())
                .password(fake.internet().password())
                .build();
    }

}
