package org.example.eserciziosettimana5.configurations;

import com.github.javafaker.Faker;
import org.example.eserciziosettimana5.models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Locale;

@Configuration
public class BookConfiguration {

    @Bean("createbook")
    @Scope("prototype")
    public Book createBook() {
        return new Book();
    }

    @Bean("createbookdetail")
    @Scope("prototype")
    public BookDetail createBookDetail() {
        return new BookDetail();
    }

    @Bean("createfakebook")
    @Scope("prototype")
    public Book createFakeBook() {
        Faker faker = new Faker(new Locale("it-IT"));
        BookDetail bookDetail = BookDetail.builder()
                .numeroPagine(faker.number().numberBetween(50, 500))
                .editore(faker.book().publisher())
                .lingua(faker.nation().language())
                .build();
        Author author = Author.builder()
                .nome(faker.name().fullName())
                .nazionalita(faker.nation().nationality())
                .build();

        Category category = Category.builder()
                .nome(faker.book().genre())
                .build();

        return Book.builder()
                .titolo(faker.book().title())
                .annoPubblicazione(faker.number().numberBetween(1950, 2025))
                .isbn(faker.number().digits(10))
                .dettaglio(bookDetail)
                .autore(author)
                .categorie(List.of(category))
                .build();
    }

}
