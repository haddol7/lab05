package com.haddol7.lab05calculator;

public class CalculatorEngine {
    public double add(double left, double right) {
        return left + right;
    }

    public double subtract(double left, double right) {
        return left - right;
    }

    public double divide(double left, double right) {
        return right == 0.0 ? 0.0 : left / right;
    }

    public double multiply(double left, double right) {
        return left * right;
    }

    public double calculate(double left, String operator, double right) {
        switch (operator) {
            case "+":
                return add(left, right);
            case "-":
                return subtract(left, right);
            case "×":
            case "*":
                return multiply(left, right);
            case "÷":
            case "/":
                return divide(left, right);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
    }
}

