package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteDAORepository {

    // CRUD Clienti
    public void salvaCliente(Cliente cliente);
    public Cliente leggiCliente(long id);
    public void modificaCliente(Cliente cliente);
    public void eliminaCliente(Cliente cliente);

    public List<Cliente> leggiTuttiCliente();

}
