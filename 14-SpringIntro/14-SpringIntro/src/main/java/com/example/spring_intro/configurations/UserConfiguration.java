package com.example.spring_intro.configurations;

import com.example.spring_intro.classes.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("application.properties")
public class UserConfiguration {

    @Value("${user.admin.name}") private String adminName;
    @Value("${user.admin.lastname}") private String adminLastname;
    @Value("${user.admin.age}") private Integer adminAge;
    @Value("${user.admin.city}") private String adminCity;
    @Value("${user.admin.email}") private String adminEmail;

    @Bean
    @Scope("singleton")
    public User adminUser() {
        return new User(adminName, adminLastname, adminAge, adminCity, adminEmail);
    }

    @Bean
    @Scope("prototype")
    public User customUser(String firstName, String lastName,  int age, String city, String email) {
        // controlli
        return new User(firstName, lastName, age, city, email);
    }

}
