package by.realovka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/history")
public class HistoryController {

    @RequestMapping("/history-get")
    public ModelAndView getHistory(ModelAndView modelAndView){
        modelAndView.setViewName("history");
        return modelAndView;
    }
//    @PostMapping("/history-get")
//    public ModelAndView postHistory(String operationType, ModelAndView modelAndView){
//
//    }
}
