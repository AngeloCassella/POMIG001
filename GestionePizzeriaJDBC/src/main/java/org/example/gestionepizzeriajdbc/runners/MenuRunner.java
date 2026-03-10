package org.example.gestionepizzeriajdbc.runners;

import org.example.gestionepizzeriajdbc.models.Drink;
import org.example.gestionepizzeriajdbc.models.Menu;
import org.example.gestionepizzeriajdbc.models.Pizza;
import org.example.gestionepizzeriajdbc.models.Prodotto;
import org.example.gestionepizzeriajdbc.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class MenuRunner implements CommandLineRunner {

    @Autowired MenuService menuService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MenuRunner...");

        // Save menu
        // Menu menu = menuService.creaMenu("Pizzeria da Peppe");
        // menuService.salvaMenu(menu);

        // Find menu
        Menu menu = menuService.leggiMenu(2);
        //System.out.println("Menu: " + menu);
        menu.stampaMenu();

        // Update Menu
        // menu.setNome("Pizzeria da Peppino");
        // menuService.modificaMenu(menu);

        // Delete Menu
        // menuService.eliminaMenu(menu);

        // Pizza margherita = menuService.creaPizza("Pizza Margherita", 6.00, List.of("Pomodoro", "Mozzarella"), menu);
        // menuService.salvaProdotto(margherita);
        // Drink cocaCola = menuService.creaDrink("Coca Cola", 3.00, 0, menu);
        // menuService.salvaProdotto(cocaCola);

        // Prodotto margherita = menuService.leggiProdotto(1);
        // System.out.println("Prodotto: " + margherita);
        // Prodotto cocaCola = menuService.leggiProdotto(2);
        // System.out.println("Prodotto: " + cocaCola);

        // margherita.setPrezzo(6.50);
        // menuService.modificaProdotto(margherita);
        // ((Drink) cocaCola).setGradi(1);
        // menuService.modificaProdotto(cocaCola);

        // menuService.eliminaProdotto(margherita);

        // menuService.leggiProdotti(2).forEach(System.out::println);


//        Pizza margherita = menuService.creaPizza("Pizza Margherita", 6.00, List.of("Pomodoro", "Mozzarella"), menu);
//        Pizza boscaiola = menuService.creaPizza("Pizza Boscaiola", 8.00, List.of("Mozzarella", "Funghi", "Salsiccia"), menu);
//        Pizza diavola = menuService.creaPizza("Pizza Diavola", 7.00, List.of("Pomodoro", "Mozzarella", "Salame piccante"), menu);
//
//        Drink cocaCola = menuService.creaDrink("Coca Cola", 3.00, 0, menu);
//        Drink birra = menuService.creaDrink("Birra", 5.00, 6, menu);
//        Drink acqua = menuService.creaDrink("Acqua", 2.00, 0, menu);
//
//        menuService.salvaProdotto(margherita);
//        menuService.salvaProdotto(boscaiola);
//        menuService.salvaProdotto(diavola);
//        menuService.salvaProdotto(cocaCola);
//        menuService.salvaProdotto(birra);
//        menuService.salvaProdotto(acqua);


    }
}
