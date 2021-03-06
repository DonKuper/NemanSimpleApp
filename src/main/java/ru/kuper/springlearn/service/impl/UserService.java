package ru.kuper.springlearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuper.springlearn.domain.User;
import ru.kuper.springlearn.repo.UserRepository;
import ru.kuper.springlearn.service.IUserService;

import javax.transaction.Transactional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
