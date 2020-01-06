package ru.kuper.springlearn.repo;

import org.springframework.data.repository.CrudRepository;
import ru.kuper.springlearn.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
