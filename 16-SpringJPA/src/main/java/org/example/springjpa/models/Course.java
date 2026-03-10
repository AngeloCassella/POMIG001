package org.example.springjpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long id;
    @Column(name = "course_name", nullable = false)
    private String courseName;
    @Column(nullable = true)
    private Integer hours;

    // Solo se voglio una relazione bidirezionale
    @ManyToMany(mappedBy = "courses")
    private List<User> users;

}
