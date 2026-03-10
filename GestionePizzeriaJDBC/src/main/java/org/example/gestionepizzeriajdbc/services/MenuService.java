package org.example.gestionepizzeriajdbc.services;

import org.example.gestionepizzeriajdbc.models.Drink;
import org.example.gestionepizzeriajdbc.models.Menu;
import org.example.gestionepizzeriajdbc.models.Pizza;
import org.example.gestionepizzeriajdbc.models.Prodotto;
import org.example.gestionepizzeriajdbc.repositories.MenuDAORepository;
import org.example.gestionepizzeriajdbc.repositories.ProdottiDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired MenuDAORepository menuRepo;
    @Autowired ProdottiDAORepository prodottiRepo;
    @Autowired @Qualifier("creaPizza") ObjectProvider<Pizza> pizzaObjectProvider;
    @Autowired @Qualifier("creaDrink") ObjectProvider<Drink> drinkObjectProvider;
    @Autowired @Qualifier("creaMenu") ObjectProvider<Menu> menuObjectProvider;

    public Pizza creaPizza(String nome, double prezzo, List<String> ingredienti, Menu menu) {
        Pizza pizza = pizzaObjectProvider.getObject();
        pizza.setNome(nome);
        pizza.setPrezzo(prezzo);
        pizza.setIngredienti(ingredienti);
        pizza.setMenu(menu);
        return pizza;
    }

    public Drink creaDrink(String nome, double prezzo, int gradi, Menu menu) {
        Drink drink = drinkObjectProvider.getObject();
        drink.setNome(nome);
        drink.setPrezzo(prezzo);
        drink.setGradi(gradi);
        drink.setMenu(menu);
        return drink;
    }

    public Menu creaMenu(String nome) {
        Menu menu = menuObjectProvider.getObject();
        menu.setNome(nome);
        return menu;
    }


    // DB method JDBC
    // CRUD Menu
    public void salvaMenu(Menu menu) {
        menuRepo.salvaMenu(menu);
    }
    public Menu leggiMenu(long id) {
        Menu menu = menuRepo.leggiMenu(id);
        // leggi i prodotti
        menu.setListaProdotto(leggiProdotti(menu.getId()));
        // Prodotti separati per tipo pizze + Drink
//        List<Pizza>  listaPizze = leggiProdotti(menu.getId())
//                                        .stream()
//                                        .filter(p -> p instanceof Pizza)
//                                        .map(p -> (Pizza) p)
//                                        .toList();
//        List<Drink>  listaDrink = leggiProdotti(menu.getId())
//                                        .stream()
//                                        .filter(p -> p instanceof Drink)
//                                        .map(p -> (Drink) p)
//                                        .toList();
//        List<Prodotto> listaProdotti = List.of((Prodotto) listaPizze, (Prodotto)listaDrink);
        return menu;
    }
    public void modificaMenu(Menu menu) {
        menuRepo.modificaMenu(menu);
    }
    public void eliminaMenu(Menu menu) {
        menuRepo.eliminaMenu(menu);
    }

    // CRUD Prodotti
    public void salvaProdotto(Prodotto prodotto) {
        prodottiRepo.salvaProdotto(prodotto);
    }
    public Prodotto leggiProdotto(long id) {
        return prodottiRepo.leggiProdotto(id);
    }
    public void modificaProdotto(Prodotto prodotto) {prodottiRepo.modificaProdotto(prodotto);}
    public void eliminaProdotto(Prodotto prodotto) {prodottiRepo.eliminaProdotto(prodotto);}
    public List<Prodotto> leggiProdotti(long menu_id) {
        return prodottiRepo.leggiTuttiProdotti(menu_id);
    }
}
