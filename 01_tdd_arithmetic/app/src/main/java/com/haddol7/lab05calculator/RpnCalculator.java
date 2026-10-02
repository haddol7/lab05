package com.haddol7.lab05calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class RpnCalculator {
    public double evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("수식이 비어 있습니다.");
        }

        Deque<Double> stack = new ArrayDeque<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                calculateTopValues(stack, token);
            } else {
                stack.push(parseNumber(token));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("올바른 RPN 수식이 아닙니다.");
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token)
                || "×".equals(token)
                || "÷".equals(token);
    }

    private void calculateTopValues(Deque<Double> stack, String operator) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("연산에 필요한 숫자가 부족합니다.");
        }

        double right = stack.pop();
        double left = stack.pop();

        switch (operator) {
            case "+":
                stack.push(left + right);
                break;
            case "-":
                stack.push(left - right);
                break;
            case "*":
            case "×":
                stack.push(left * right);
                break;
            case "/":
            case "÷":
                stack.push(right == 0.0 ? 0.0 : left / right);
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
    }

    private double parseNumber(String token) {
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자 또는 연산자를 확인하세요.", exception);
        }
    }
}

