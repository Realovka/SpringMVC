package by.realovka.controller;

import by.realovka.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/user-home-page")
public class UserHomePageController {

    @GetMapping("/get")
    public ModelAndView getHomePage(User user, ModelAndView modelAndView){
        return modelAndView;
    }
}
