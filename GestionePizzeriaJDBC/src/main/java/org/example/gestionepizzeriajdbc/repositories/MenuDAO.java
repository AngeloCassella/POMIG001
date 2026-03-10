package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MenuDAO implements MenuDAORepository {

    //    CREATE TABLE IF NOT EXISTS pomig001_spring_pizzeria_jdbc.menu (
    //            menu_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    //            nome_menu VARCHAR(100) NOT NULL );

    @Autowired JdbcTemplate jdbc;

    @Override
    public void salvaMenu(Menu menu) {
        String sql = "INSERT INTO menu (nome_menu)  VALUES (?)";
        jdbc.update(sql, menu.getNome());
        System.out.println("Menu " +  menu.getNome() + " salvato nel DB!");
    }

    @Override
    public Menu leggiMenu(long id) {
        String sql = "SELECT * FROM menu WHERE menu_id = ?";
        return jdbc.queryForObject(sql, new MenuRowMapper(), id);
    }

    @Override
    public void modificaMenu(Menu menu) {
        String sql = "UPDATE menu SET nome_menu = ? WHERE menu_id = ?";
        jdbc.update(sql, menu.getNome(), menu.getId());
        System.out.println("Menu " +  menu.getNome() + " modificato nel DB!");
    }

    @Override
    public void eliminaMenu(Menu menu) {
        String sql = "DELETE FROM menu WHERE menu_id = ?";
        jdbc.update(sql, menu.getId());
        System.out.println("Menu " +  menu.getNome() + " eliminato dal DB!");
    }



}
