package by.realovka.controller;

import by.realovka.entity.User;
import by.realovka.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/reg-user")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/reg")
    public ModelAndView getReg(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView postReg(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.createUser(user);
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }


}
