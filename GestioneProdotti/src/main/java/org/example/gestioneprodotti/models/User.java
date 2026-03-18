package org.example.gestioneprodotti.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,  nullable = false)
    private String username;
    @Column(unique = true,  nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Relazione uno-a-molti con Order
}
