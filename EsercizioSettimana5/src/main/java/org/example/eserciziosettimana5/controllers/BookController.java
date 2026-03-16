package org.example.eserciziosettimana5.controllers;

import org.example.eserciziosettimana5.models.Book;
import org.example.eserciziosettimana5.models.Category;
import org.example.eserciziosettimana5.services.AuthorService;
import org.example.eserciziosettimana5.services.BookService;
import org.example.eserciziosettimana5.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String books(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping("/new")
    public String createbooks(Model model) {
        model.addAttribute("book", new  Book());
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") long id,  Model model) {
        model.addAttribute("book", bookService.findBook(id));
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @GetMapping("/edit/category/{id}")
    public String addCategoryBook(@PathVariable("id") long id,  Model model) {
        model.addAttribute("book", bookService.findBook(id));
        model.addAttribute("categories", categoryService.findAll());
        return "book-category";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        bookService.deleteBookByID(id);
        return "redirect:/books";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @PostMapping("/save/category")
    public String saveCategoryBook(@RequestParam long book, @RequestParam long category) {
        Book b = bookService.findBook(book);
        Category c = categoryService.findCategory(category);
        bookService.assignCategoryToBook(b, c);
    return "redirect:/books";
    }


}
