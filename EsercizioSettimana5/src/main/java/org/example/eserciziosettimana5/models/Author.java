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
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Long id;
    @Column(name = "author_name", nullable = false)
    private String nome;
    @Column(name = "nationality")
    private String nazionalita;

    // Relazioni
    // Author 1 ---- N Book
    @OneToMany(mappedBy = "autore",  fetch = FetchType.EAGER)
    List<Book> libri;


}
