package org.example.eserciziosettimana5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "book_details")
public class BookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_detail_id", nullable = false)
    private Long id;
    @Column(name = "number_pages")
    private Integer numeroPagine;
    @Column(name = "language")
    private String lingua;
    @Column(name = "publisher", nullable = false)
    private String editore;

    // Relazioni
    // BookDetail 1 ---- 1 Book
    @OneToOne(mappedBy = "dettaglio")
    private Book libro;

    @Override
    public String toString() {
        return "BookDetail{" +
                "id=" + id +
                ", numeroPagine=" + numeroPagine +
                ", lingua='" + lingua + '\'' +
                ", editore='" + editore + '\'' +
                '}';
    }
}
