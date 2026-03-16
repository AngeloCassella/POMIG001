package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.Book;
import org.example.eserciziosettimana5.models.Loan;
import org.example.eserciziosettimana5.models.User;

import java.util.List;

public interface LoanService {

    public Loan createLoan(User utente, Book libro);
    public void closeLoan(Loan loan);
    public List<Loan> activeLoans();
    public void saveLoan(Loan loan);
    public Loan findLoan(long id);
    public List<Loan> findAll();
    public void deleteLoan(Loan loan);

}
