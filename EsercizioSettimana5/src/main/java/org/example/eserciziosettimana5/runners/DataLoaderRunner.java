package org.example.eserciziosettimana5.runners;

import org.example.eserciziosettimana5.models.*;
import org.example.eserciziosettimana5.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoaderRunner implements CommandLineRunner {

    @Autowired AuthorService  authorService;
    @Autowired CategoryService categoryService;
    @Autowired UserService userService;
    @Autowired BookService bookService;
    @Autowired LoanService loanService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataLoader Runner starting...");

        if(authorService.findAll().size() == 0 &&
                categoryService.findAll().size() == 0 &&
                bookService.findAll().size() == 0 &&
                userService.findAll().size() == 0) {

            Author author = authorService.createAuthor("Umberto Eco", "Italia");
            authorService.saveAuthor(author);
            Category category = categoryService.createCategory("Romanzo");
            categoryService.saveCategory(category);
            User user = userService.createUser("Mario Rossi", "m.rossi@example.com", "+39 123.456.789");
            userService.saveUser(user);
            Book book = bookService.createBook("Il nome della rosa", "123456789", 1980, 100, "Italiano", "Bompiani", List.of(category), author);
            bookService.saveBook(book);
            Loan loan = loanService.createLoan(user, book);
            loanService.saveLoan(loan);

            Author author2 = authorService.createAuthor("George Orwell", "Regno Unito");
            authorService.saveAuthor(author2);
            Category category2 = categoryService.createCategory("Distopia");
            categoryService.saveCategory(category2);
            User user2 = userService.createUser("Giulia Bianchi", "g.bianchi@example.com", "+39 333444555");
            userService.saveUser(user2);
            Book book2 = bookService.createBook("1984", "9780451524935", 1949, 328, "Inglese", "Secker & Warburg", List.of(category2), author2);
            bookService.saveBook(book2);
            Loan loan2 = loanService.createLoan(user2, book2);
            loanService.saveLoan(loan2);

            Author author3 = authorService.createAuthor("J.R.R. Tolkien", "Regno Unito");
            authorService.saveAuthor(author3);
            Category category3 = categoryService.createCategory("Fantasy");
            categoryService.saveCategory(category3);
            User user3 = userService.createUser("Luca Verdi", "l.verdi@example.com", "+39 333666777");
            userService.saveUser(user3);
            Book book3 = bookService.createBook("Il Signore degli Anelli", "9788845292637", 1954, 1178, "Inglese", "Allen & Unwin", List.of(category3), author3);
            bookService.saveBook(book3);
            Loan loan3 = loanService.createLoan(user3, book3);
            loanService.saveLoan(loan3);

            Author author4 = authorService.createAuthor("Harper Lee", "Stati Uniti");
            authorService.saveAuthor(author4);
            Category category4 = categoryService.createCategory("Narrativa");
            categoryService.saveCategory(category4);
            User user4 = userService.createUser("Sara Neri", "s.neri@example.com", "+39 333888999");
            userService.saveUser(user4);
            Book book4 = bookService.createBook("Il buio oltre la siepe", "9780061120084", 1960, 281, "Inglese", "J.B. Lippincott & Co.", List.of(category4), author4);
            bookService.saveBook(book4);
            Loan loan4 = loanService.createLoan(user4, book4);
            loanService.saveLoan(loan4);

            Author author5 = authorService.createAuthor("Dan Brown", "Stati Uniti");
            authorService.saveAuthor(author5);
            Category category5 = categoryService.createCategory("Thriller");
            categoryService.saveCategory(category5);
            User user5 = userService.createUser("Andrea Fontana", "a.fontana@example.com", "+39 333222111");
            userService.saveUser(user5);
            Book book5 = bookService.createBook("Il Codice Da Vinci", "9780385504205", 2003, 454, "Inglese", "Doubleday", List.of(category5), author5);
            bookService.saveBook(book5);
            Loan loan5 = loanService.createLoan(user5, book5);
            loanService.saveLoan(loan5);
        } else {
            System.out.println("DataLoader completed");
        }
    }
}
