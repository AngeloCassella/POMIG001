package com.example.spring_intro.classes;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String email;

    public User(String firstName, String lastName, Integer age, String city, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.email = email;
    }

}
