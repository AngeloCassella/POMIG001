package org.example.gestionepizzeriajdbc.services;

import org.example.gestionepizzeriajdbc.models.Cliente;
import org.example.gestionepizzeriajdbc.models.Ordine;
import org.example.gestionepizzeriajdbc.models.Prodotto;
import org.example.gestionepizzeriajdbc.repositories.ClienteDAORepository;
import org.example.gestionepizzeriajdbc.repositories.OrdineDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdineService {

    @Autowired ClienteDAORepository clienteRepo;
    @Autowired OrdineDAORepository ordineRepo;
    @Autowired @Qualifier("creaCliente") ObjectProvider<Cliente> clienteObjectProvider;
    @Autowired @Qualifier("creaClienteFake") ObjectProvider<Cliente> clienteFakeObjectProvider;
    @Autowired @Qualifier("creaOrdine") ObjectProvider<Ordine> ordineObjectProvider;

    public Cliente creaCliente(String nome, String telefono) {
        Cliente cliente = clienteObjectProvider.getObject();
        cliente.setNome(nome);
        cliente.setTelefono(telefono);
        return cliente;
    }

    public Cliente creaClienteFake() {
        return clienteFakeObjectProvider.getObject();
    }

    public Ordine creaOrdine(Cliente cliente, List<Prodotto> listaProdotti) {
        Ordine ordine = ordineObjectProvider.getObject();
        ordine.setCliente(cliente);
        ordine.setDataOrdine(LocalDate.now());
        ordine.setProdottiOrdinati(listaProdotti);
        ordine.setTotale(listaProdotti.stream().mapToDouble(Prodotto::getPrezzo).sum());
        return ordine;
    }

    // DB method JDBC
    // CRUD Clienti
    public void salvaCliente(Cliente cliente) {
        clienteRepo.salvaCliente(cliente);
    }
    public Cliente leggiCliente(long id) { return clienteRepo.leggiCliente(id);}
    public void modificaCliente(Cliente cliente) {
        clienteRepo.modificaCliente(cliente);
    }
    public void elimicaCliente(Cliente cliente) {clienteRepo.eliminaCliente(cliente); }
    public List<Cliente> lettiTuttiClienti() {return clienteRepo.leggiTuttiCliente(); }

    // CRUD Ordini
    public void salvaOrdine(Ordine ordine) {ordineRepo.salvaOrdine(ordine); }
    public Ordine leggiOrdine(long numeroOrdine) {
        Ordine ordine = ordineRepo.leggiOrdine(numeroOrdine);
        ordine.setProdottiOrdinati(ordineRepo.leggiProdottiOrdine(numeroOrdine));
        return ordine;
    }
    public void modificaOrdine(Ordine ordine) {ordineRepo.modificaOrdine(ordine); }
    public void eliminaOrdine(Ordine ordine) {ordineRepo.eliminaOrdine(ordine); }
}
