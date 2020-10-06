package by.realovka.controller;

import by.realovka.entity.Operation;
import by.realovka.service.CalcService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(path = "/calc")
public class CalcController {

    private ArrayList<Operation> operationArrayList;

    private CalcService calcService;

    public CalcController(ArrayList<Operation> operationArrayList, CalcService calcService) {
        this.operationArrayList = operationArrayList;
        this.calcService = calcService;
    }

    @GetMapping(path = "/calc-page")
    public ModelAndView getCalc(ModelAndView modelAndView){
        modelAndView.addObject("operation", new Operation());
        modelAndView.setViewName("calc");
        return modelAndView;
    }

    @PostMapping(path = "/calc-page")
    public ModelAndView postCalc(@Valid Operation operation, HttpSession session, BindingResult bindingResult, ModelAndView modelAndView){
        if (!bindingResult.hasErrors()){
            modelAndView.addObject("result", calcService.calc(operation));
            operation.setResult(calcService.calc(operation));
            operationArrayList.add(operation);
            session.setAttribute("history", operationArrayList);
        }
        modelAndView.setViewName("calc");
        return modelAndView;
    }
}
