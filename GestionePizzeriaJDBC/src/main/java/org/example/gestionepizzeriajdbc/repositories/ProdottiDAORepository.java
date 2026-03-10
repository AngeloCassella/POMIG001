package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Prodotto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottiDAORepository {

    // CRUD Prodotti
    public void salvaProdotto(Prodotto prodotto);
    public Prodotto leggiProdotto(long id);
    public void modificaProdotto(Prodotto prodotto);
    public void eliminaProdotto(Prodotto prodotto);

    public List<Prodotto> leggiTuttiProdotti(long menuId);
}
