package org.example.gestionepizzeriajdbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    private Long id;
    private String nome;
    private String telefono;

    public Cliente(String nome, String telefono) {
        this.nome = nome;
        this.telefono = telefono;
    }
}
