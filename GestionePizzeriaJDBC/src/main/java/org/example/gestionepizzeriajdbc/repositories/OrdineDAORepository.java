package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Cliente;
import org.example.gestionepizzeriajdbc.models.Ordine;
import org.example.gestionepizzeriajdbc.models.Prodotto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineDAORepository {

    // CRUD Ordine
    public void salvaOrdine(Ordine ordine);
    public Ordine leggiOrdine(long id);
    public void modificaOrdine(Ordine ordine);
    public void eliminaOrdine(Ordine ordine);

    public List<Ordine> leggiTuttiOrdine();
    public List<Prodotto> leggiProdottiOrdine(long numeroOrdine);

}
