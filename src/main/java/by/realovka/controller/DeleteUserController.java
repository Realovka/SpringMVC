package by.realovka.controller;

import by.realovka.entity.User;
import by.realovka.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/delete")
public class DeleteUserController {

    private UserService userService;

    public DeleteUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/deleteUser")
    public ModelAndView deleteUser(HttpSession httpSession, ModelAndView modelAndView){
      userService.deleteUserFromDB((User)httpSession.getAttribute("userAuth"));
      httpSession.invalidate();
      modelAndView.setViewName("delete");
      return modelAndView;
    }
}
