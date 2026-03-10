package org.example.gestionepizzeriajdbc.repositories;

import org.example.gestionepizzeriajdbc.models.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDAORepository {

    // CRUD Menu
    public void salvaMenu(Menu menu);
    public Menu leggiMenu(long id);
    public void modificaMenu(Menu menu);
    public void eliminaMenu(Menu menu);

}
