package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.Book;
import org.example.eserciziosettimana5.models.Loan;
import org.example.eserciziosettimana5.models.User;
import org.example.eserciziosettimana5.repositories.LoanRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired @Qualifier("createloan") ObjectProvider<Loan> loanObjectProvider;
    @Autowired LoanRepository loanRepo;

    public Loan createLoan(User utente, Book libro) {
        Loan loan = loanObjectProvider.getObject();
        loan.setLibro(libro);
        loan.setUtente(utente);
        loan.setDataPrestito(LocalDate.now());
        return loan;
    }

    @Override
    public void closeLoan(Loan loan) {
        loan.setDataRestituzione(LocalDate.now());
        loanRepo.save(loan);
        System.out.println("Loan closed: " + loan.getDataRestituzione());
    }

    @Override
    public List<Loan> activeLoans() {
        return loanRepo.findByDataRestituzioneIsNull();
    }

    @Override
    public void saveLoan(Loan loan) {
        loanRepo.save(loan);
        System.out.println("Loan saved: " + loan.getDataPrestito());
    }

    @Override
    public Loan findLoan(long id) {
        return loanRepo.findById(id).orElse(null);
    }

    @Override
    public List<Loan> findAll() {
        return loanRepo.findAll();
    }

    @Override
    public void deleteLoan(Loan loan) {
        loanRepo.delete(loan);
    }

}
