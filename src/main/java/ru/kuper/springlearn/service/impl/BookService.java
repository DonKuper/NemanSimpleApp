package ru.kuper.springlearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.repo.BookRepository;
import ru.kuper.springlearn.service.IBookService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Iterable<Book> findSortedBooks() {
        return bookRepository.findSortedBooks();
    }

    @Override
    @Transactional
    public Optional findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional findById(String id) {
        return bookRepository.findById(Long.valueOf(id));
    }

    @Override
    @Transactional
    public Iterable<Book> findByAuthorOrName(String author, String name) {
        return bookRepository.findByAuthorOrName(author, name);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        bookRepository.deleteById(Long.valueOf(id));
    }


}
