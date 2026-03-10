package org.example.gestionepizzeriajdbc.configurations;

import com.github.javafaker.Faker;
import org.example.gestionepizzeriajdbc.models.Cliente;
import org.example.gestionepizzeriajdbc.models.Ordine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class OrdineConfiguration {

    // Cliente Bean
    @Bean("creaCliente")
    @Scope("prototype")
    public Cliente creaCliente() {
        return new Cliente();
    }

    // Cliente Bean
    @Bean("creaClienteFake")
    @Scope("prototype")
    public Cliente creaClienteFake() {
        Faker fake = new Faker(new Locale("it-IT"));
        Cliente cliente = new Cliente();
        cliente.setNome(fake.name().fullName());
        cliente.setTelefono(fake.phoneNumber().phoneNumber());
        return cliente;
    }

    // Ordine Bean
    @Bean("creaOrdine")
    @Scope("prototype")
    public Ordine creaOrdine() {
        return new Ordine();
    }

}
