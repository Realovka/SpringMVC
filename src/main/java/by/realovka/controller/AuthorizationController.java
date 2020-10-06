package by.realovka.controller;

import by.realovka.entity.User;
import by.realovka.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
@Controller
@RequestMapping(path = "/auth-user")
public class AuthorizationController {

    private UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/auth")
    public ModelAndView getAuth(ModelAndView modelAndView) {
        modelAndView.addObject("userAuth", new User());
        modelAndView.setViewName("authorization");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView postAuth(@Valid @ModelAttribute("userAuth") User user, BindingResult bindingResult, HttpSession httpSession, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("authorization");
        } else
        if (userService.authorizeUser(user)) {
            User authUser = userService.getUserFromDB(user);
            //сетим юзера в сессию, чтобы можно было его изменять в UpdateUserController
            httpSession.setAttribute("userAuth", authUser);
            httpSession.setAttribute("userNameAuth", authUser.getName());
            modelAndView.setViewName("hello");
        }
        return modelAndView;
    }
}
