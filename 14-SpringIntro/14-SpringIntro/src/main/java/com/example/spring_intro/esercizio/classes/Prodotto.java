package com.example.spring_intro.esercizio.classes;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Prodotto {

    private String nome;
    private Double prezzo;

    @Override
    public String toString() {
        return nome + ", prezzo: €" + prezzo;
    }
}
