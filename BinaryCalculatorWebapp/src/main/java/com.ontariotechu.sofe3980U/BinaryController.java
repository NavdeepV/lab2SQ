package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BinaryController {

    @GetMapping("/")
    public String getCalculator(@RequestParam(name="operand1", required=false, defaultValue="") String operand1, Model model) {
        model.addAttribute("operand1", operand1);
        model.addAttribute("operand1Focused", operand1.length() > 0);
    return "calculator";
    }

    @PostMapping("/")
    public String result(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
    @RequestParam(name="operator", required=false, defaultValue="") String operator,
    @RequestParam(name="operand2", required=false, defaultValue="") String operand2, Model model) {
        model.addAttribute("operand1", operand1);
        model.addAttribute("operator", operator);
        model.addAttribute("operand2", operand2);
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        switch (operator) 
        {
            case "+": //ADD case
                model.addAttribute("result", Binary.add(number1, number2).getValue());
                return "result";
            case "*": //MULTIPLY case
                model.addAttribute("result", Binary.multiply(number1, number2).getValue());
                return "result";
            case "&": //AND case
                model.addAttribute("result", Binary.and(number1, number2).getValue());
                return "result";
            case "|":  //OR  case
                model.addAttribute("result", Binary.or(number1, number2).getValue());
                return "result";
            default: //ERROR case
                model.addAttribute("error", "Invalid operation");
                return "error";
        }

    }

    @PostMapping("/multiply")
    public String postMultiplication(@RequestParam String binary1, @RequestParam String binary2, Model model) {
        System.out.println("Multiplication is: " + binary1 + " * " + binary2);  //record input values 

        try {//binary nums 1 and 2 input strings
            Binary bin1 = new Binary(binary1);
            Binary bin2 = new Binary(binary2);
            Binary result = Binary.multiply(bin1, bin2); // multiply both binary num 1 and binary num 2
            model.addAttribute("result", result.getValue()); // add the result to be shown 
        return "result";  //return the result 
        } 
        catch (Exception error) {  //handle an expections aka the errors
            System.out.println("Error multiplication: " + error.getMessage());  //record error 
            model.addAttribute("error", "Error multiplication"); //add error message to be shown
        return "error";  //return error 
        }
    }
}
