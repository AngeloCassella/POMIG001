package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Cliente;
import org.example.gestionepizzeriajdbc.models.Ordine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdineRowMapper implements RowMapper<Ordine> {
    @Override
    public Ordine mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getLong("clienti_id"));
        cliente.setNome(rs.getString("nome_cliente"));
        cliente.setTelefono(rs.getString("telefono"));

        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(rs.getInt("numeroOrdine"));
        ordine.setCliente(cliente);
        ordine.setDataOrdine(rs.getDate("dataOrdine").toLocalDate());
        ordine.setTotale(rs.getDouble("totale"));
        return ordine;
    }
}
