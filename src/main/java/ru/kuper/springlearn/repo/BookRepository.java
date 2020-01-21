package ru.kuper.springlearn.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.kuper.springlearn.model.Book;

import java.util.Iterator;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findByAuthorOrName(String author, String name);

//    @Query("SELECT c FROM book as c")
//    Iterable<Book> findSortedBooks();

}
