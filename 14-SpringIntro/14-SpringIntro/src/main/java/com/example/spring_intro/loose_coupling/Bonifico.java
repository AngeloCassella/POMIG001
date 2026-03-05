package com.example.spring_intro.loose_coupling;

public class Bonifico implements  PaymentGatwey {
    public void processPayment(double totalOrder) {
        System.out.println("Pagamento di €" + totalOrder + " effettuato con successo tramite Bonifico.");
    }
}
