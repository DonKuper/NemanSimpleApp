package ru.kuper.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.repo.BookRepository;
import ru.kuper.springlearn.service.SoundAnimals;

@Controller
@RequestMapping("/")
public class HomeController {

    private BookRepository bookRepository;
    private SoundAnimals soundAnimals;

    //Один из вариантов однозначно определить реализацию Sound Animals:
    //public HomeController(BookRepository bookRepository, @Qualifier("catSound") SoundAnimals soundAnimals)
    @Autowired
    public HomeController(BookRepository bookRepository, SoundAnimals soundAnimals) {
        this.bookRepository = bookRepository;
        this.soundAnimals = soundAnimals;
    }

    @GetMapping
    public String getIndex(Model model) {
        System.out.println("From controller: " + soundAnimals.sound());
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
