package ru.kuper.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.repo.BookRepository;
import ru.kuper.springlearn.service.SoundAnimals;

import java.util.Optional;

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
//        System.out.println("From controller: " + soundAnimals.sound());
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("newBook",new Book());
        return "index";
    }

    @PostMapping
    public String createBook(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    //Поиск книг
    /*
    @GetMapping
    public String findBooksForm() {
        return "search";
    }

    @PostMapping("/search")
    public String findBooks(Book book, Model model) {
        model.addAttribute("books", bookRepository.findByAuthorOrName(book.getAuthor(), book.getName()));
        return "showFinded";
    }
*/

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
    public String editBook(@PathVariable("id") Long id, Book book) {
        System.out.println(book);
        bookRepository.save(book);
        return "redirect:/";
    }


}
