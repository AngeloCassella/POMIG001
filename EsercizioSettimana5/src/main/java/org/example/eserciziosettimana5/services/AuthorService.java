package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.Author;

import java.util.List;

public interface AuthorService {

    public Author createAuthor(String nome, String nazionalita);
    public Author createFakeAuthor();
    public void saveAuthor(Author author);
    public Author findAuthor(long id);
    public List<Author> findAll();
    public void deleteAuthor(Author author);

}
