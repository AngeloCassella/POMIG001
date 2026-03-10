package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteDAO implements ClienteDAORepository {

    @Autowired JdbcTemplate jdbc;

    //    CREATE TABLE IF NOT EXISTS pomig001_spring_pizzeria_jdbc.clienti (
    //            clienti_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    //            nome_cliente VARCHAR(100) NOT NULL,
    //            telefono VARCHAR(50) NULL);

    @Override
    public void salvaCliente(Cliente cliente) {
        String sql = "INSERT INTO clienti (nome_cliente, telefono) VALUES (?, ?)";
        jdbc.update(sql, cliente.getNome(), cliente.getTelefono());
        System.out.println("Cliente " + cliente.getNome() + " salvato nel DB!");
    }

    @Override
    public Cliente leggiCliente(long id) {
        String sql = "SELECT * FROM clienti WHERE clienti_id = ?";
        return jdbc.queryForObject(sql, new ClienteRowMapper(), id);
    }

    @Override
    public void modificaCliente(Cliente cliente) {
        String sql = "UPDATE clienti SET nome_cliente=?, telefono=? WHERE clienti_id=?";
        jdbc.update(sql, cliente.getNome(), cliente.getTelefono(), cliente.getId());
        System.out.println("Cliente " + cliente.getNome() + " modificato nel DB!");
    }

    @Override
    public void eliminaCliente(Cliente cliente) {
        String sql = "DELETE FROM clienti WHERE clienti_id=?";
        jdbc.update(sql, cliente.getId());
        System.out.println("Cliente " + cliente.getNome() + " eliminato dal DB!");
    }

    @Override
    public List<Cliente> leggiTuttiCliente() {
        String sql = "SELECT * FROM clienti";
        return jdbc.query(sql, new ClienteRowMapper());
    }



}
