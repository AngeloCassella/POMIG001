package org.example.eserciziosettimana5.configurations;

import org.example.eserciziosettimana5.models.Loan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LoanConfiguration {

    @Bean("createloan")
    @Scope("prototype")
    public Loan createLoan() {
        return new Loan();
    }

}
