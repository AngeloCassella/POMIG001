package org.example.eserciziosettimana5.controllers;

import org.example.eserciziosettimana5.models.Author;
import org.example.eserciziosettimana5.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired AuthorService authorService;

    @GetMapping
    public String authors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

    @GetMapping("/new")
    public String createAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "author-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") long id) {
        authorService.deleteAuthor(authorService.findAuthor(id));
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String editAuthor(@PathVariable("id") long id,  Model model) {
        model.addAttribute("author", authorService.findAuthor(id));
        return "author-form";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }
}
