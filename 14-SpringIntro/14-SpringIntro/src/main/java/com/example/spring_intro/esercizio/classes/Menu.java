package com.example.spring_intro.esercizio.classes;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Menu {

    private String nome;
    //private List<Pizza> listaPizze;
    //private List<Drink> listaDrink;
    private List<Prodotto> listaProdotto;

    public Menu(String nome) {
        this.nome = nome;
        //this.listaPizze = new ArrayList<>();
        //this.listaDrink = new ArrayList<>();
        this.listaProdotto = new ArrayList<>();
    }

    public void stampaMenu() {
        System.out.println("************* Menu " + this.nome + " **************");
        System.out.println("----- Pizze -----");
        this.listaProdotto.forEach(prodotto -> {
            if(prodotto instanceof Pizza){
                System.out.println(prodotto);
            }
        });
        System.out.println("----- Drink -----");
        this.listaProdotto.forEach(prodotto -> {
            if(prodotto instanceof Drink){
                System.out.println(prodotto);
            }
        });

    }
}
