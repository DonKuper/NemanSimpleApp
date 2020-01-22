package ru.kuper.springlearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.repo.BookRepository;
import ru.kuper.springlearn.service.IBookService;

import java.util.Optional;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Iterable<Book> findSortedBooks() {
        return bookRepository.findSortedBooks();
    }

    @Override
    public Optional findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional findById(String id) {
        return bookRepository.findById(Long.valueOf(id));
    }

    @Override
    public Iterable<Book> findByAuthorOrName(String author, String name) {
        return bookRepository.findByAuthorOrName(author, name);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteById(String id) {
        bookRepository.deleteById(Long.valueOf(id));
    }


}
