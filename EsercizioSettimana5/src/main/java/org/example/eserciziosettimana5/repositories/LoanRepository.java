package org.example.eserciziosettimana5.repositories;

import org.example.eserciziosettimana5.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    List<Loan> findByDataRestituzioneIsNull();
}
