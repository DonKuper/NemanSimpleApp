package ru.kuper.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuper.springlearn.domain.RegistrationForm;
import ru.kuper.springlearn.service.impl.UserService;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Autowired
    public RegistrationController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping
    public String registration(){
        return "reg/registration";
    }

    @PostMapping
    public String processUser(RegistrationForm form) {
       userService.save(form.toUser(passwordEncoder));
       return  "redirect:/login";
    }

}
