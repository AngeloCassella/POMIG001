package org.example.gestionepizzeriajdbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ordine {

    private Integer numeroOrdine;
    private Cliente cliente;
    private List<Prodotto> prodottiOrdinati = new ArrayList<>();
    private LocalDate dataOrdine;
    private double totale;

    public void stampaOrdine() {
        System.out.println("************* Ordine n." + this.numeroOrdine + " **************");
        System.out.println("Cliente: " + this.cliente.getNome() + " (" + this.cliente.getTelefono() + ")");
        System.out.println("Data Ordine: " + this.dataOrdine);
        System.out.println("Dettaglio ordine: ");
        System.out.println("----- Pizze -----");
        this.prodottiOrdinati.forEach(prodotto -> {
            if(prodotto instanceof Pizza){
                System.out.println(prodotto);
            }
        });
        System.out.println("----- Drink -----");
        this.prodottiOrdinati.forEach(prodotto -> {
            if(prodotto instanceof Drink){
                System.out.println(prodotto);
            }
        });
        System.out.println("Totale: €" + this.totale);

    }

}
