package com.example.spring_intro.loose_coupling;

public class OrderProcessor {

    // private PaymentGatwey paymentGatwey = new PaymentGatwey(); // Errore
    // private PaymentGatwey paymentGatwey = new PostePay(); // Accoppiamento forte

    private PaymentGatwey paymentGatwey; // Accoppiamento debole

    // Dependency Injection su Costruttore
    public OrderProcessor(PaymentGatwey paymentGatwey) {
        this.paymentGatwey = paymentGatwey;
    }

    // Dependency Injection su Setter
    public void setPaymentGatwey(PaymentGatwey paymentGatwey) {
        this.paymentGatwey = paymentGatwey;
    }

    public void processOrder(Order order) {
        paymentGatwey.processPayment(order.getTotale());
    }
}
