package com.example.spring_intro.loose_coupling;

public class PostePay implements PaymentGatwey {
    @Override
    public void processPayment(double totalOrder) {
        System.out.println("Pagamento di €" + totalOrder + " effettuato con successo tramite PostePay.");
    }
}
