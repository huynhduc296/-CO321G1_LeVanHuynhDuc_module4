package com.example.model.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String calculator(double numberOne, double numberSecond, String calculator) {
        String result ="";
        switch (calculator) {
            case "+":
                result = "Addition :"+ (numberOne + numberSecond);
                break;
            case "-":
                result = "Subtraction :"+ (numberOne - numberSecond);
                break;
            case "*":
                result = "Multiplication :" +(numberOne * numberSecond);
                break;
            case "/":
                result = "Division :" +(numberOne / numberSecond);
                break;
        }
        return result;
    }
}
