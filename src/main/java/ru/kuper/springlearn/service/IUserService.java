package ru.kuper.springlearn.service;

import ru.kuper.springlearn.domain.User;
import ru.kuper.springlearn.repo.UserRepository;

public interface IUserService {

    User save(User user);

    User findByUsername(String name);


}
