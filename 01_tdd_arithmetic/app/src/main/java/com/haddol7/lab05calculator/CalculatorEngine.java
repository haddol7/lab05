package com.haddol7.lab05calculator;

public class CalculatorEngine {
    public double calculate(double left, String operator, double right) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "×":
            case "*":
                return left * right;
            case "÷":
            case "/":
                return right == 0.0 ? 0.0 : left / right;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
    }
}

