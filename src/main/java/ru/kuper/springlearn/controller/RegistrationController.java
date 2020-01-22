package ru.kuper.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuper.springlearn.domain.RegistrationForm;
import ru.kuper.springlearn.repo.UserRepository;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String registration(){
        return "reg/registration";
    }

    @PostMapping
    public String processUser(RegistrationForm form) {
       userRepository.save(form.toUser(passwordEncoder));
       return  "redirect:/login";
    }

}
