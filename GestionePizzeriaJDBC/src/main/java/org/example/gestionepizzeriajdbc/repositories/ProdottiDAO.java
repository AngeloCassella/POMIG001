package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Drink;
import org.example.gestionepizzeriajdbc.models.Pizza;
import org.example.gestionepizzeriajdbc.models.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdottiDAO implements ProdottiDAORepository {

    @Autowired JdbcTemplate jdbc;

    //    CREATE TABLE IF NOT EXISTS pomig001_spring_pizzeria_jdbc.prodotti (
//            prodotti_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
//            nome_prodotto VARCHAR(100) NOT NULL,
//        prezzo DECIMAL(8,2) NOT NULL,
//        menu_id INT NOT NULL,
//        tipo VARCHAR(50) NOT NULL,
//        ingredienti_pizza VARCHAR(255) NULL,
//        gradi_drink INT NULL,
//        CONSTRAINT fk_menu_prodotti FOREIGN KEY(menu_id)
//        REFERENCES menu(menu_id) ON DELETE CASCADE ON UPDATE CASCADE
//    );

    @Override
    public void salvaProdotto(Prodotto prodotto) {
        String sql = "INSERT INTO prodotti (nome_prodotto, prezzo, menu_id, " +
                "tipo, ingredienti_pizza, gradi_drink) VALUES (?, ?, ?, ?, ?, ?)";

//        String ingredienti;
//        if(prodotto instanceof Pizza) {
//            Pizza pizza = (Pizza) prodotto;
//            ingredienti = pizza.getIngredienti().toString();
//        } else {
//            ingredienti = null;
//        }

        String ingredienti = (prodotto instanceof Pizza) ?
                ((Pizza) prodotto).getIngredienti().toString() : null;
        Integer gradi = (prodotto instanceof Drink) ?
                ((Drink) prodotto).getGradi() :  null;
        jdbc.update(sql,
                prodotto.getNome(),
                prodotto.getPrezzo(),
                prodotto.getMenu().getId(),
                prodotto.getClass().getSimpleName(),
                ingredienti,
                gradi);
        System.out.println("Prodotto " + prodotto.getNome() + " salvato nel DB!");

    }

    @Override
    public Prodotto leggiProdotto(long id) {
        String sql = "SELECT * FROM prodotti AS p " +
                "INNER JOIN menu AS m ON p.menu_id = m.menu_id " +
                "WHERE prodotti_id = ?";
        return jdbc.queryForObject(sql, new ProdottiRowMapper(), id);
    }

    @Override
    public void modificaProdotto(Prodotto prodotto) {
        String sql = "UPDATE prodotti SET nome_prodotto=?, prezzo=?, menu_id=?, " +
                "tipo=?, ingredienti_pizza=?, gradi_drink=? WHERE prodotti_id = ?";

        String ingredienti = (prodotto instanceof Pizza) ?
                ((Pizza) prodotto).getIngredienti().toString() : null;
        Integer gradi = (prodotto instanceof Drink) ?
                ((Drink) prodotto).getGradi() :  null;

        jdbc.update(sql,
                prodotto.getNome(),
                prodotto.getPrezzo(),
                prodotto.getMenu().getId(),
                prodotto.getClass().getSimpleName(),
                ingredienti,
                gradi,
                prodotto.getId());
        System.out.println("Prodotto " + prodotto.getNome() + " modificato nel DB!");
    }

    @Override
    public void eliminaProdotto(Prodotto prodotto) {
        String sql = "DELETE FROM prodotti WHERE prodotti_id = ?";
        jdbc.update(sql, prodotto.getId());
        System.out.println("Prodotto " + prodotto.getNome() + " eliminato dal DB!");
    }

    @Override
    public List<Prodotto> leggiTuttiProdotti(long menuId) {
        String sql = "SELECT * FROM prodotti AS p " +
                "INNER JOIN menu AS m ON p.menu_id = m.menu_id " +
                "WHERE m.menu_id = ?";
        return jdbc.query(sql, new ProdottiRowMapper(), menuId);
    }




}
