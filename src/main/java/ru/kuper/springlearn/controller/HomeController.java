package ru.kuper.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kuper.springlearn.domain.Role;
import ru.kuper.springlearn.domain.User;
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.repo.BookRepository;
import ru.kuper.springlearn.util.UtilClass;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class HomeController {

    private BookRepository bookRepository;

    private UtilClass utilClass;

    private boolean isUser = false, isAdmin = false;

    @Autowired
    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.utilClass = new UtilClass();
    }

    @GetMapping
    public String getIndex(@AuthenticationPrincipal User user, Model model) {
//        System.out.println("From controller: " + soundAnimals.sound());
        if (user != null) {
            isUser = user.getRoles().contains(Role.USER);
            isAdmin = user.getRoles().contains(Role.ADMIN);
            model.addAttribute("user", user.getUsername());
        } else {
            model.addAttribute("user", "anonymous");
            isUser = false; isAdmin = false;
        }
        model.addAttribute("isUser",isUser);
        model.addAttribute("isAdmin",isAdmin);
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("newBook",new Book());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "reg/login";
    }

    @PreAuthorize(value = "hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/foruser")
    public String foruser() {
        return "foruser";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/foradmin")
    public String foradmin(){
        return "foradmin";
    }


    @GetMapping("/sortedlist")
    public ModelAndView getsortedlist(Model model) {
        Iterable<Book> iterable = bookRepository.findSortedBooks();
        model.addAttribute("books",iterable);
        return new ModelAndView("sortedlist","books", iterable);
    }

    @PostMapping(params = "action=save")
    public String saveBook(@Valid Book book, Errors errors){
        bookRepository.save(book);
        return "redirect:/";
    }

    @PostMapping(params = "action=find")
    public ModelAndView findBooks(Book book, Model model) {
       Iterable<Book> iterable = bookRepository.findByAuthorOrName(book.getAuthor(),book.getName());
       Collection collection = utilClass.makeCollection(iterable);
       if (!collection.isEmpty()) {
           model.addAttribute("books", iterable);
       }
       return new ModelAndView("showfinded","books",iterable);

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
