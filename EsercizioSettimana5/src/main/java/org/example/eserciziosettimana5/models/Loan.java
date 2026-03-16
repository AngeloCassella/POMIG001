package org.example.eserciziosettimana5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id", nullable = false)
    private Long id;
    @Column(name = "loan_date" , nullable = false)
    private LocalDate dataPrestito;
    @Column(name = "return_date")
    private LocalDate dataRestituzione;

    // Relazioni

    // Loan N ---- 1 User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User utente;

//    Loan N ---- 1 Book
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book libro;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", dataPrestito=" + dataPrestito +
                ", dataRestituzione=" + dataRestituzione +
                ", utente=" + utente.getNome() +
                ", libro=" + libro.getTitolo() +
                '}';
    }
}
