package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

    @PostMapping("/plus")
    public ModelAndView plus(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2,
            ModelAndView mav) {
        int value = num1 + num2;
        mav.addObject("value", value);
        mav.setViewName("result");
        return mav;
    }

}
