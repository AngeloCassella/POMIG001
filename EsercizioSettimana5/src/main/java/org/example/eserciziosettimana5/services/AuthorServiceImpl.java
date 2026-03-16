package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.Author;
import org.example.eserciziosettimana5.repositories.AuthorRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired @Qualifier("createauthor") ObjectProvider<Author> createAuthorProvider;
    @Autowired @Qualifier("createfakeauthor") ObjectProvider<Author> createFakeAuthorProvider;
    @Autowired AuthorRepository authorRepo;

    public Author createAuthor(String nome, String nazionalita) {
        Author author = createAuthorProvider.getObject();
        author.setNome(nome);
        author.setNazionalita(nazionalita);
        return author;
    }

    public Author createFakeAuthor() {
        return createFakeAuthorProvider.getObject();
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepo.save(author);
        System.out.println("Author saved: " + author.getNome());
    }

    @Override
    public Author findAuthor(long id) {
        return authorRepo.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    @Override
    public void deleteAuthor(Author author) {
        authorRepo.delete(author);
        System.out.println("Author deleted: " + author.getNome());
    }

}
