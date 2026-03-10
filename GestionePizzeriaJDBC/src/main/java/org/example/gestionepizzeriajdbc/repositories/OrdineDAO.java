package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Ordine;
import org.example.gestionepizzeriajdbc.models.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class OrdineDAO implements OrdineDAORepository{

//    CREATE TABLE IF NOT EXISTS pomig001_spring_pizzeria_jdbc.ordini (
//            numeroOrdine INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
//            clienti_id INT NOT NULL,
//            dataOrdine DATE NOT NULL,
//            totale DOUBLE NOT NULL,
//            CONSTRAINT fk_ordine_cliente FOREIGN KEY(clienti_id)
//    REFERENCES clienti(clienti_id) ON DELETE CASCADE ON UPDATE CASCADE);
//
//    CREATE TABLE IF NOT EXISTS pomig001_spring_pizzeria_jdbc.ordine_prodotti (
//            ordine_id INT NOT NULL,
//            prodotti_id INT NOT NULL,
//            CONSTRAINT fk1_ordine_prodotti FOREIGN KEY(ordine_id)
//    REFERENCES ordini(numeroOrdine) ON DELETE CASCADE ON UPDATE CASCADE,
//    CONSTRAINT fk2_ordine_prodotti FOREIGN KEY(prodotti_id)
//    REFERENCES prodotti(prodotti_id) ON DELETE CASCADE ON UPDATE CASCADE);

    @Autowired JdbcTemplate jdbc;


    @Override
    public void salvaOrdine(Ordine ordine) {
        String sql = "INSERT INTO ordini (clienti_id, dataOrdine, totale) VALUES (?, ?, ?)";
        //jdbc.update(sql, ordine.getCliente().getId(), ordine.getDataOrdine(), ordine.getTotale());

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder(); //Oggetto che serve per leggere l'ultimo ID creato
        jdbc.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Imposto il paramentro Statement.RETURN_GENERATED_KEYS nel prepareStatement
                ps.setLong(1, ordine.getCliente().getId());
                ps.setString(2, ordine.getDataOrdine().toString());
                ps.setDouble(3, ordine.getTotale());
                return ps;
            }
        },  keyHolder); // Oggetto keyHolder serve per recuperare l'ultimo ID creato

        long idOrdine = keyHolder.getKey().longValue(); // Leggo ID creato e lo trasformo in un tipo Long

        String sql2 = "INSERT INTO ordine_prodotti (ordine_id, prodotti_id) VALUES (?, ?)";
        ordine.getProdottiOrdinati().forEach(prodotti -> {
            jdbc.update(sql2, idOrdine, prodotti.getId());
        });


        System.out.println("Ordine " + idOrdine + " salvato nel DB!");
    }

    @Override
    public Ordine leggiOrdine(long id) {
        String sql = "SELECT * FROM ordini AS o " +
                     "INNER JOIN clienti AS c ON c.clienti_id = o.clienti_id " +
                     "WHERE numeroOrdine = ?;";
        return jdbc.queryForObject(sql, new OrdineRowMapper(), id);
    }

    @Override
    public List<Prodotto> leggiProdottiOrdine(long numeroOrdine) {
        String sql = "SELECT * FROM ordini AS o " +
                "INNER JOIN ordine_prodotti AS op ON op.ordine_id = o.numeroOrdine " +
                "INNER JOIN prodotti AS p ON p.prodotti_id = op.prodotti_id " +
                "INNER JOIN menu AS m ON p.menu_id = m.menu_id " +
                "WHERE numeroOrdine = ?;";
        return jdbc.query(sql, new ProdottiRowMapper(),  numeroOrdine);
    }

    @Override
    public void modificaOrdine(Ordine ordine) {
        String sql = "UPDATE ordini SET clienti_id=?, dataOrdine=?, totale=? WHERE numeroOrdine=?";

        jdbc.update(sql,
                ordine.getCliente().getId(),
                ordine.getDataOrdine(),
                ordine.getTotale(),
                ordine.getNumeroOrdine());

        // rimuove i prodotti esistenti
        String deleteSql = "DELETE FROM ordine_prodotti WHERE ordine_id=?";
        jdbc.update(deleteSql, ordine.getNumeroOrdine());

        // inserisce i nuovi prodotti
        String insertSql = "INSERT INTO ordine_prodotti (ordine_id, prodotti_id) VALUES (?, ?)";

        ordine.getProdottiOrdinati().forEach(prodotto -> {
            jdbc.update(insertSql,
                    ordine.getNumeroOrdine(),
                    prodotto.getId());
        });

        System.out.println("Ordine " + ordine.getNumeroOrdine() + " modificato nel DB!");
    }

    @Override
    public void eliminaOrdine(Ordine ordine) {
        String sql = "DELETE FROM ordini WHERE numeroOrdine=?;";
        jdbc.update(sql, ordine.getNumeroOrdine());
        System.out.println("Ordine " + ordine.getNumeroOrdine() + " eliminato dal DB!");
    }

    @Override
    public List<Ordine> leggiTuttiOrdine() {
        String sql = "SELECT * FROM ordini AS o " +
                "INNER JOIN clienti AS c ON c.clienti_id = o.clienti_id;";
        return jdbc.query(sql, new OrdineRowMapper());
    }


}
