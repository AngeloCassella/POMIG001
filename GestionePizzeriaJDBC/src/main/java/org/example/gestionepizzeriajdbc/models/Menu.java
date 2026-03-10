package org.example.gestionepizzeriajdbc.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Menu {

    private Long id;
    private String nome;
    private List<Prodotto> listaProdotto = new ArrayList<>();

    public Menu(String nome) {
        this.nome = nome;
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
