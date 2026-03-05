package com.example.spring_intro.esercizio.configurations;

import com.example.spring_intro.esercizio.classes.Drink;
import com.example.spring_intro.esercizio.classes.Menu;
import com.example.spring_intro.esercizio.classes.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class PizzeriaConfig {

    // Menu Bean
    @Bean
    @Scope("singleton")
    public Menu creaMenu() {
        Menu menu = new Menu("Pizzeria da Peppe");
//        menu.getListaPizze().add(creaPizzaMargherita());
//        menu.getListaPizze().add(creaPizzaBoscaiola());
//        menu.getListaPizze().add(creaPizzaDiavola());
//        menu.getListaPizze().add(creaPizzaCustom("Pizza Olive", 6.5, List.of("Pomodoro", "Olive", "Capperi")));
//        menu.getListaDrink().add(creaDrinkAcqua());
//        menu.getListaDrink().add(creaDrinkBirra());
//        menu.getListaDrink().add(creaDrinkCocaCola());
//        menu.getListaDrink().add(creaDrinkCustom("Spritz", 10.00, 12));
        menu.getListaProdotto().add(creaPizzaMargherita());
        menu.getListaProdotto().add(creaPizzaBoscaiola());
        menu.getListaProdotto().add(creaPizzaDiavola());
        menu.getListaProdotto().add(creaPizzaCustom("Pizza Olive", 6.5, List.of("Pomodoro", "Olive", "Capperi")));
        menu.getListaProdotto().add(creaDrinkAcqua());
        menu.getListaProdotto().add(creaDrinkBirra());
        menu.getListaProdotto().add(creaDrinkCocaCola());
        menu.getListaProdotto().add(creaDrinkCustom("Spritz", 10.00, 12));
        return menu;

    }


    // Pizza Bean
    @Bean
    @Scope("singleton")
    public Pizza creaPizzaMargherita() {
        return new Pizza("Pizza Margherita", 6.00, List.of("Pomodoro", "Mozzarella"));
    }

    @Bean
    @Scope("singleton")
    public Pizza creaPizzaBoscaiola() {
        return new Pizza("Pizza Boscaiola", 8.00, List.of("Mozzarella", "Funghi", "Salsiccia"));
    }

    @Bean
    @Scope("singleton")
    public Pizza creaPizzaDiavola() {
        return new Pizza("Pizza Diavola", 7.00, List.of("Pomodoro", "Mozzarella", "Salame piccante"));
    }

    @Bean
    @Scope("prototype")
    public Pizza creaPizzaCustom(String nome, Double prezzo, List<String> ingredienti) {
        return new Pizza(nome, prezzo, ingredienti);
    }

    @Bean
    @Scope("prototype")
    public Pizza creaPizza() {
        return new Pizza();
    }

    // Drink Bean
    @Bean
    @Scope("singleton")
    public Drink creaDrinkCocaCola() {
        return new Drink("Coca Cola", 3.00, 0);
    }

    @Bean
    @Scope("singleton")
    public Drink creaDrinkBirra() {
        return new Drink("Birra", 5.00, 6);
    }

    @Bean
    @Scope("singleton")
    public Drink creaDrinkAcqua() {
        return new Drink("Acqua", 2.00, 0);
    }

    @Bean
    @Scope("prototype")
    public Drink creaDrinkCustom(String nome, Double prezzo, Integer gradi) {
        return new Drink(nome, prezzo, gradi);
    }

    @Bean
    @Scope("prototype")
    public Drink creaDrink() {
        return new Drink();
    }


}
