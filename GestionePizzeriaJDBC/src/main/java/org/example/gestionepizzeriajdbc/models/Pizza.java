package org.example.gestionepizzeriajdbc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pizza extends Prodotto {

    private List<String> ingredienti = new ArrayList<String>();

    public Pizza(String nome, Double prezzo, List<String> ingredienti, Menu menu) {
        super(nome, prezzo, menu);
        this.ingredienti = ingredienti;
    }

    @Override
    public String toString() {
        return " - " + super.toString() + " ingredienti: " + ingredienti;
    }

}
