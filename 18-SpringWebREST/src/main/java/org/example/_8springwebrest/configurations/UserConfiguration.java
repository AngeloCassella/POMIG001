package org.example._8springwebrest.configurations;

import com.github.javafaker.Faker;
import org.example._8springwebrest.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
        Faker faker = new Faker();
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .age(faker.number().numberBetween(18,80))
                .city(faker.address().cityName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .build();
    }

}
