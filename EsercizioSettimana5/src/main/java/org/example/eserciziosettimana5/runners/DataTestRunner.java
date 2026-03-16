package org.example.eserciziosettimana5.runners;

import org.example.eserciziosettimana5.models.*;
import org.example.eserciziosettimana5.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataTestRunner implements CommandLineRunner {

    @Autowired AuthorService authorService;
    @Autowired CategoryService categoryService;
    @Autowired UserService userService;
    @Autowired BookService bookService;
    @Autowired LoanService loanService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataTest Runner starting...");

        // Author test
        // Author author = authorService.createAuthor("Mario Rossi", "Italiana");
        // System.out.println("Autore: " + author);
        // Author fakeAuthor = authorService.createFakeAuthor();
        // System.out.println("Autore: " + fakeAuthor);

        // Category test
        // Category category = categoryService.createCategory("Azione");
        // System.out.println("Categoria: " + category);
        // Category fakeCategory = categoryService.createFakeCategory();
        // System.out.println("Categoria: " + fakeCategory);

        // User test
        // User user = userService.createUser("Giuseppe Verdi", "g.verdi@example.com", "+39 123.456.789");
        // System.out.println("Utente: " + user);
        // User fakeUser = userService.createFakeUser();
        // System.out.println("Utente: " + fakeUser);

        // Book test
        // Category letteratura = categoryService.createCategory("Letteratura");
        // Author ammaniti = authorService.createAuthor("Niccolò Ammaniti", "Italiana");
        // Book book = bookService.createBook("Il custode", "9788806255145", 2026, 176, "Italiano", "Einaudi", List.of(letteratura), ammaniti);
        // System.out.println("Libro: " + book);
        // Book fakeBook = bookService.createFakeBook();
        // System.out.println("Libro: " + fakeBook);

        // Loan test
        // Loan loan = loanService.createLoan(user, book);
        // System.out.println("Loan: " + loan);

        // Category CRUD
        // Category cat = categoryService.createCategory("Letteratura");
        // Category cat = categoryService.createCategory("Horror");
        // categoryService.saveCategory(cat);
        // Category let = categoryService.findCategory(1);
        // System.out.println("Categoria: " + let);
        // let.setNome(fakeCategory.getNome());
        // categoryService.saveCategory(let);
        // categoryService.findAll().forEach(System.out::println);
        // categoryService.deleteCategory(let);

        // Author CRUD
        // Author aut = authorService.createAuthor("Mario Rossi", "Italiana");
        // Author aut = authorService.createAuthor("Niccolò Ammaniti", "Italiana");
        // authorService.saveAuthor(aut);
        // Author mario = authorService.findAuthor(1);
        // System.out.println("Author: " + mario);
        // mario.setNazionalita("Francese");
        // authorService.saveAuthor(mario);
        // authorService.findAll().forEach(System.out::println);
        // authorService.deleteAuthor(mario);

        // User CRUD
        // User u = userService.createUser("Giuseppe Verdi", "g.verdi@example.com", "+39 123.456.789");
        // userService.saveUser(u);
        // User giu = userService.findUser(1);
        // System.out.println("User: " + giu);
        // giu.setTelefono("+39 987-654-321");
        // giu.setEmail("g.verdi@web.com");
        // giu.setNome("Giuseppe Neri");
        // userService.saveUser(giu);
        // userService.findAll().forEach(System.out::println);
        // userService.deleteUser(giu);

        // Book CRUD
        // Category lett = categoryService.findCategory(2);
        // Category horror = categoryService.findCategory(3);
        // Author nicolo = authorService.findAuthor(3);
        // Book IlCustode = bookService.createBook("Il custode", "9788806255145", 2026, 176, "Italiano", "Einaudi", List.of(lett), nicolo);
        // System.out.println("Libro: " + IlCustode);
        // bookService.saveBook(IlCustode);
        // Book IlCustode = bookService.findBook(3);
        // bookService.assignCategoryToBook(IlCustode, horror);
        // System.out.println("Book: " + IlCustode);

        // Loan CRUD
        // User giu = userService.findUser(2);
        // Book IlCustode = bookService.findBook(3);
        // Loan l = loanService.createLoan(giu, IlCustode);
        // System.out.println("Loan: " + l);
        // loanService.saveLoan(l);
        // Loan l = loanService.findLoan(1);
        // System.out.println("Loan: " + l);
        // loanService.closeLoan(l);
        // loanService.findAll().forEach(System.out::println);
        // loanService.activeLoans().forEach(System.out::println);


    }
}
