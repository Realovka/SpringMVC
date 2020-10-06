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
@RequestMapping("/update-user")
public class UpdateUserController {
    private UserService userService;

    public UpdateUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/update")
    public ModelAndView getUpdateUser(ModelAndView modelAndView) {
        modelAndView.addObject("userUpdate", new User());
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView postUpdateUser(@Valid @ModelAttribute("userUpdate") User user, BindingResult bindingResult, HttpSession httpSession, ModelAndView modelAndView) {
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("update");
        } else {
            userService.updateUserInDB((User) httpSession.getAttribute("userAuth"), user);
            //удаление атрибутов старого юзера
            httpSession.removeAttribute("userNameAuth");
            httpSession.removeAttribute("userAuth");
            httpSession.setAttribute("userNameAuth", user.getName());
            httpSession.setAttribute("userAuth", user);
            modelAndView.setViewName("hello");
        }
        return modelAndView;
    }
}
