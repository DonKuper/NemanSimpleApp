package ru.kuper.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.repo.BookRepository;
import ru.kuper.springlearn.service.SoundAnimals;
import ru.kuper.springlearn.util.Util;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    private BookRepository bookRepository;
    private SoundAnimals soundAnimals;
    private Util util;

    //Один из вариантов однозначно определить реализацию Sound Animals:
    //public HomeController(BookRepository bookRepository, @Qualifier("catSound") SoundAnimals soundAnimals)

    @Autowired
    public HomeController(BookRepository bookRepository, SoundAnimals soundAnimals) {
        this.bookRepository = bookRepository;
        this.soundAnimals = soundAnimals;
        this.util = new Util();
    }

    @GetMapping
    public String getIndex(Model model) {
//        System.out.println("From controller: " + soundAnimals.sound());
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("newBook",new Book());
        return "index";
    }

//    @PostMapping
//    public String createBook(@ModelAttribute Book book, @RequestParam(value="action", required=true) String action ) {
//
//        if (action.equals("save")) {
//            bookRepository.save(book);
//            return "redirect:/";
//        }
//    }

    @PostMapping(params = "action=save")
    public String saveBook(Book book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @PostMapping(params = "action=find")
    public void findBooks(Book book, Model model) {
       Iterable<Book> iterable = bookRepository.findByAuthorOrName(book.getAuthor(),book.getName());
       Collection collection = util.makeCollection(iterable);
       if (!collection.isEmpty()) {
           model.addAttribute("books",collection);
           findBookslist(model);
       }

    }

    @GetMapping("/showfinded")
    public String findBookslist(Model model) {
        return "showfinded";
    }


    @GetMapping("/{id}/show")
    public String showById(@PathVariable("id") Long id, Model model) {
        Optional bookObject = bookRepository.findById(id);
        if(bookObject.isPresent()) {
            model.addAttribute(bookObject.get());
            return "show";
        }
        model.addAttribute("book",new Book());
        return "show";
    }

    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editFormById(@PathVariable("id") Long id, Model model) {
        Optional bookObject = bookRepository.findById(id);
        model.addAttribute(bookObject.get());
        return "edit";
    }

    @PostMapping("/{id}")
    public String editBook(@PathVariable("id") Long id, @Valid Book book, Errors errors) {
        if (errors.hasErrors()) {
            return "edit";
        }
        bookRepository.save(book);
        return "redirect:/";
    }


}
