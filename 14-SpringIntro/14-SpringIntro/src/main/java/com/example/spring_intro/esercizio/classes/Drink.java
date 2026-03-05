package com.example.spring_intro.esercizio.classes;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Drink extends Prodotto {

    private Integer gradi;

    public Drink(String nome, Double prezzo, Integer gradi) {
        super(nome, prezzo);
        this.gradi = gradi;
    }

    @Override
    public String toString() {
        return " - " + super.toString() + " gradi: " + gradi;
    }

}
