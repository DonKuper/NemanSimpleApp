package ru.kuper.springlearn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.repo.BookRepository;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class HomeControllerRest {
   private BookRepository bookRepository;

    public HomeControllerRest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Optional<Book> bookMaybe = bookRepository.findById(id);
        if (bookMaybe.isPresent()){
            return new ResponseEntity<>(bookMaybe.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public Book postBook(@RequestBody Book book) {
     return bookRepository.save(book);
    }
}
