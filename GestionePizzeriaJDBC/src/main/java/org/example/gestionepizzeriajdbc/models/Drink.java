package org.example.gestionepizzeriajdbc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Drink extends Prodotto {

    private Integer gradi;

    public Drink(String nome, Double prezzo, Integer gradi, Menu menu) {
        super(nome, prezzo, menu);
        this.gradi = gradi;
    }

    @Override
    public String toString() {
        return " - " + super.toString() + " gradi: " + gradi;
    }

}
