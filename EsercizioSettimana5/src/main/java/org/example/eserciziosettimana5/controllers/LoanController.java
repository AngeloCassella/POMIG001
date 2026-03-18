package org.example.eserciziosettimana5.controllers;

import org.example.eserciziosettimana5.models.Loan;
import org.example.eserciziosettimana5.models.User;
import org.example.eserciziosettimana5.services.BookService;
import org.example.eserciziosettimana5.services.LoanService;
import org.example.eserciziosettimana5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loans")
public class LoanController {

    @Autowired LoanService loanService;
    @Autowired BookService bookService;
    @Autowired UserService userService;

    @GetMapping
    public String loans(Model model) {
        model.addAttribute("loans", loanService.findAll());
        return "loans";
    }

    @GetMapping("/new")
    public String createLoan(Model model) {
        model.addAttribute("loan", new Loan());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("users", userService.findAll());
        return "loan-form";
    }

    @GetMapping("/close/{id}")
    public String closeLoan(@PathVariable("id") long id,  Model model) {
        loanService.closeLoan(loanService.findLoan(id));
        return "redirect:/loans";
    }

    @GetMapping("/edit/{id}")
    public String editLoan(@PathVariable("id") long id,  Model model) {
        model.addAttribute("loan", loanService.findLoan(id));
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("users", userService.findAll());
        return "loan-form";
    }

    @PostMapping("/save")
    public String saveLoan(@ModelAttribute Loan loan) {
        loanService.saveLoan(loan);
        return "redirect:/loans";
    }
}
