package com.example.demo.mysql;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 一覧表示
    @GetMapping({ "", "/" })
    public ModelAndView index(ModelAndView mav) {
        Iterable<User> users = userRepository.findAll();
        mav.addObject("users", users);
        mav.setViewName("user");
        return mav;
    }

    // ユーザー登録
    @GetMapping("/add")
    public ModelAndView add(ModelAndView mav) {
        User user = new User();
        mav.addObject("newUser", user);
        mav.setViewName("add");
        return mav;
    }

    @PostMapping("/add")
    @Transactional(readOnly = false)
    public ModelAndView add(@ModelAttribute("newUser") User user) {
        userRepository.saveAndFlush(user);
        return new ModelAndView("redirect:/user");
    }
}
