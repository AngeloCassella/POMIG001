package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.*;
import org.example.eserciziosettimana5.repositories.BookRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired @Qualifier("createbook") ObjectProvider<Book> createBookObjectProvider;
    @Autowired @Qualifier("createbookdetail") ObjectProvider<BookDetail> createBookDetailObjectProvider;
    @Autowired @Qualifier("createfakebook") ObjectProvider<Book> createFakeBookObjectProvider;
    @Autowired BookRepository bookRepo;

    public Book createBook(String titolo, String isbn, Integer annoPubblicazione, Integer numeroPagine, String lingua, String editore, List<Category> categorie, Author autore) {
        BookDetail dettaglio = createBookDetailObjectProvider.getObject();
        dettaglio.setLingua(lingua);
        dettaglio.setNumeroPagine(numeroPagine);
        dettaglio.setEditore(editore);

        Book book = createBookObjectProvider.getObject();
        book.setTitolo(titolo);
        book.setAnnoPubblicazione(annoPubblicazione);
        book.setIsbn(isbn);
        book.setDettaglio(dettaglio);
        book.setAutore(autore);
        book.setCategorie(categorie);
        book.setPrestiti(new ArrayList<>());
        return book;
    }


    public Book createFakeBook() {
        return createFakeBookObjectProvider.getObject();
    }

    @Override
    public void assignCategoryToBook(Book book, Category category) {
        book.getCategorie().add(category);
        bookRepo.save(book);
    }

    @Override
    public void saveBook(Book book) {
        bookRepo.save(book);
        System.out.println("Book saved: " + book.getTitolo());
    }

    @Override
    public Book findBook(long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public void deleteBook(Book book) {
        bookRepo.delete(book);
        System.out.println("Book deleted: " + book.getTitolo());
    }

    @Override
    public void deleteBookByID(long id) {
        bookRepo.deleteById(id);
        System.out.println("Book deleted!");
    }

}
