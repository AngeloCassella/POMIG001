package com.example.spring_intro.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component("user_component")
@Scope("prototype")
public class UserComponent {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String email;

    public UserComponent(String firstName, String lastName, Integer age, String city, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.email = email;
    }

}
