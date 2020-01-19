package ru.kuper.springlearn.repo;

import org.springframework.data.repository.CrudRepository;
import ru.kuper.springlearn.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String name);

}
