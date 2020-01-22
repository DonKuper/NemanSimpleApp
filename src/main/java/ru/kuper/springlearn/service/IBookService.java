package ru.kuper.springlearn.service;

import ru.kuper.springlearn.model.Book;

import java.util.Optional;

public interface IBookService {

    Book save(Book book);

    Iterable<Book> findAll();

    Iterable<Book> findSortedBooks();

    Optional findById(String id);

    Optional findById(Long id);

    Iterable<Book> findByAuthorOrName(String author, String name);

    void deleteById(String id);

    void deleteById(Long id);

}
