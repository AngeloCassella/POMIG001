package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.Author;
import org.example.eserciziosettimana5.models.Book;
import org.example.eserciziosettimana5.models.Category;

import java.util.List;

public interface BookService {

    public Book createBook(String titolo, String isbn, Integer annoPubblicazione, Integer numeroPagine, String lingua, String editore, List<Category> categorie, Author autore);
    public Book createFakeBook();
    public void assignCategoryToBook(Book book, Category category);
    public void saveBook(Book book);
    public Book findBook(long id);
    public List<Book> findAll();
    public void deleteBook(Book book);
    public void deleteBookByID(long id);

}
