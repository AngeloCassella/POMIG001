package org.example.gestionepizzeriajdbc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Prodotto {

    private Long id;
    private String nome;
    private Double prezzo;
    private Menu menu;

    public Prodotto(String nome, Double prezzo,  Menu menu) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return id + " - " + nome + ", prezzo: €" + prezzo + ", menu: " + menu.getNome();
    }

}
