package ru.kuper.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.repo.BookRepository;

@Controller
public class HomeController {

    private BookRepository bookRepository;

    @Autowired
    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("newBook",new Book());
        return "index";
    }

    @PostMapping
    public String createBook(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }
}
