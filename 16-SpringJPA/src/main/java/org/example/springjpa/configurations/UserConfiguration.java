package org.example.springjpa.configurations;

import com.github.javafaker.Faker;
import org.example.springjpa.models.Address;
import org.example.springjpa.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class UserConfiguration {

    @Value("${user.admin.name}") private String adminFirstname;
    @Value("${user.admin.lastname}") private String adminLastname;
    @Value("${user.admin.age}") private int adminAge;
    @Value("${user.admin.city}") private String adminCity;
    @Value("${user.admin.street}") private String adminStreet;
    @Value("${user.admin.email}") private String adminEmail;

    @Bean("customUser")
    @Scope("prototype")
    public User createCustomUser(){
        return new User();
    }

    @Bean("fakeUser")
    @Scope("prototype")
    public User createFakeUser(){
        Faker fake = new Faker(new Locale("it-IT"));
        Address address = new Address(fake.address().streetAddress() , fake.address().city() , fake.address().state());

        return User.builder()
                .firstname(fake.name().firstName())
                .lastname(fake.name().lastName())
                .age(fake.number().numberBetween(15, 80))
                .email(fake.internet().emailAddress())
                .address(address)
                .build();
    }

    @Bean("adminUser")
    @Scope("singleton")
    public User createAdminUser(){
        Address address = new Address();
        address.setCity(adminCity);
        address.setStreet(adminStreet);
        return User.builder()
                .firstname(adminFirstname)
                .lastname(adminLastname)
                .age(adminAge)
                .email(adminEmail)
                .address(address)
                .build();
    }

}
