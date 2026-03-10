package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Menu;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuRowMapper implements RowMapper<Menu> {

    // @Autowired @Qualifier("creaMenu") ObjectProvider<Menu> menuObjectProvider;

    @Override
    public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menu menu = new Menu();
        menu.setId(rs.getLong("menu_id"));
        menu.setNome(rs.getString("nome_menu"));
        return menu;
    }

}
