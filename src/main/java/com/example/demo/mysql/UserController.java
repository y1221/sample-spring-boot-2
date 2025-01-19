package com.example.demo.mysql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping({ "", "/" })
    public ModelAndView index(ModelAndView mav) {
        Iterable<User> users = userRepository.findAll();
        mav.addObject("users", users);
        mav.setViewName("user");
        return mav;
    }
}
