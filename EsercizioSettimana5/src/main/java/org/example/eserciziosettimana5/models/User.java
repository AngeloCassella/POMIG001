package org.example.eserciziosettimana5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "phone")
    private String telefono;

    // Relazioni:
    // User 1 ---- N Loan
    @OneToMany(mappedBy = "utente",  fetch = FetchType.EAGER)
    private List<Loan> prestiti;

}
