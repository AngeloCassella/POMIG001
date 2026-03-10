package org.example.gestionepizzeriajdbc.runners;

import org.example.gestionepizzeriajdbc.models.Cliente;
import org.example.gestionepizzeriajdbc.models.Ordine;
import org.example.gestionepizzeriajdbc.models.Prodotto;
import org.example.gestionepizzeriajdbc.services.MenuService;
import org.example.gestionepizzeriajdbc.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(2)
public class OrdineRunner implements CommandLineRunner {

    @Autowired OrdineService ordineService;
    @Autowired MenuService menuService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("OrdineRunner...");

//         Cliente cliente = ordineService.creaCliente("Mario Rossi", "+39 123.456.789");
//         ordineService.salvaCliente(cliente);
//         Cliente clienteFake = ordineService.creaClienteFake();
//         ordineService.salvaCliente(clienteFake);

//        Cliente clienteOrdine = ordineService.leggiCliente(1);
//        List<Prodotto> listaProdottiOrdine = List.of(
//                                                menuService.leggiProdotto(4),
//                                                menuService.leggiProdotto(7));
//
//        Ordine o = ordineService.creaOrdine(clienteOrdine, listaProdottiOrdine);
//        ordineService.salvaOrdine(o);

//        Ordine ordine = ordineService.leggiOrdine(3);
//        ordine.stampaOrdine();
//        ordine.setDataOrdine(LocalDate.now());
//        Prodotto boscaiola = ordine.getProdottiOrdinati().get(0);
//        ordine.getProdottiOrdinati().remove(boscaiola);
//        ordine.getProdottiOrdinati().add(menuService.leggiProdotto(3));
//        ordine.setTotale(ordine.getProdottiOrdinati().stream().mapToDouble(Prodotto::getPrezzo).sum());
//        ordineService.modificaOrdine(ordine);

//        ordineService.eliminaOrdine(ordine);

//        ordineService.elimicaCliente(clienteOrdine);


    }
}
