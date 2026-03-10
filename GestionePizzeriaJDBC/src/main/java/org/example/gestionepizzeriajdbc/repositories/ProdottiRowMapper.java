package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Drink;
import org.example.gestionepizzeriajdbc.models.Menu;
import org.example.gestionepizzeriajdbc.models.Pizza;
import org.example.gestionepizzeriajdbc.models.Prodotto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdottiRowMapper implements RowMapper<Prodotto> {
    @Override
    public Prodotto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menu menu = new Menu();
        menu.setId(rs.getLong("menu_id"));
        menu.setNome(rs.getString("nome_menu"));

        if(rs.getString("tipo").equals("Pizza")){
            Pizza pizza = new Pizza();
            pizza.setId(rs.getLong("prodotti_id"));
            pizza.setNome(rs.getString("nome_prodotto"));
            pizza.setPrezzo(rs.getDouble("prezzo"));
            pizza.setIngredienti(List.of(rs.getString("ingredienti_pizza")));
            pizza.setMenu(menu);
            return pizza;
        } else if(rs.getString("tipo").equals("Drink")){
            Drink drink = new Drink();
            drink.setId(rs.getLong("prodotti_id"));
            drink.setNome(rs.getString("nome_prodotto"));
            drink.setPrezzo(rs.getDouble("prezzo"));
            drink.setGradi(rs.getInt("gradi_drink"));
            drink.setMenu(menu);
            return drink;
        }
        return null;
    }
}
