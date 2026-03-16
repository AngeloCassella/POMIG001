package org.example.eserciziosettimana5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false)
    private String titolo;
    @Column(nullable = false)
    private String isbn;
    @Column(name = "publication_year")
    private Integer annoPubblicazione;

    // Relazioni:
    // Book N ---- N Category
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categorie;

    // Book N ---- 1 Author
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author autore;

    // Book 1 ---- N Loan
    @OneToMany(mappedBy = "libro",  fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Loan> prestiti;

    // Book 1 ---- 1 BookDetail
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private BookDetail dettaglio;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
//                ", categorie=" + categorie.stream()
//                                        .map(c -> c.getNome())
//                                        .reduce("", (a, c) -> a += (c + " ")) +
                ", categorie=" + Arrays.toString(categorie.stream().map(c -> c.getNome()).toArray()) +
                ", autore=" + autore.getNome() +
                ", prestiti=" + prestiti +
                ", dettaglio=" + dettaglio +
                '}';
    }
}
