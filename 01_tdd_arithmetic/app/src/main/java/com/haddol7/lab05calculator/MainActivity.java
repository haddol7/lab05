package com.haddol7.lab05calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final int MAX_INPUT_LENGTH = 15;

    private final CalculatorEngine calculator = new CalculatorEngine();

    private TextView displayText;
    private TextView expressionText;
    private String currentInput = "0";
    private String pendingOperator;
    private double storedValue;
    private boolean startNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = findViewById(R.id.display_text);
        expressionText = findViewById(R.id.expression_text);

        bindDigitButton(R.id.button_0, "0");
        bindDigitButton(R.id.button_1, "1");
        bindDigitButton(R.id.button_2, "2");
        bindDigitButton(R.id.button_3, "3");
        bindDigitButton(R.id.button_4, "4");
        bindDigitButton(R.id.button_5, "5");
        bindDigitButton(R.id.button_6, "6");
        bindDigitButton(R.id.button_7, "7");
        bindDigitButton(R.id.button_8, "8");
        bindDigitButton(R.id.button_9, "9");

        bindOperatorButton(R.id.button_add, "+");
        bindOperatorButton(R.id.button_subtract, "-");
        bindOperatorButton(R.id.button_multiply, "×");
        bindOperatorButton(R.id.button_divide, "÷");

        findViewById(R.id.button_decimal).setOnClickListener(view -> enterDecimal());
        findViewById(R.id.button_equals).setOnClickListener(view -> calculateResult());
        findViewById(R.id.button_clear).setOnClickListener(view -> clearCalculator());
        findViewById(R.id.button_backspace).setOnClickListener(view -> backspace());
        findViewById(R.id.button_sign).setOnClickListener(view -> toggleSign());
    }

    private void bindDigitButton(int buttonId, String digit) {
        findViewById(buttonId).setOnClickListener(view -> enterDigit(digit));
    }

    private void bindOperatorButton(int buttonId, String operator) {
        findViewById(buttonId).setOnClickListener(view -> selectOperator(operator));
    }

    private void enterDigit(String digit) {
        if (startNewInput || "0".equals(currentInput)) {
            currentInput = digit;
            startNewInput = false;
        } else if (currentInput.length() < MAX_INPUT_LENGTH) {
            currentInput += digit;
        }
        updateDisplay();
    }

    private void enterDecimal() {
        if (startNewInput) {
            currentInput = "0.";
            startNewInput = false;
        } else if (!currentInput.contains(".") && currentInput.length() < MAX_INPUT_LENGTH) {
            currentInput += ".";
        }
        updateDisplay();
    }

    private void selectOperator(String operator) {
        if (pendingOperator != null && !startNewInput) {
            storedValue = performCalculation(storedValue, pendingOperator, parseCurrentInput());
            currentInput = formatNumber(storedValue);
            updateDisplay();
        } else {
            storedValue = parseCurrentInput();
        }

        pendingOperator = operator;
        expressionText.setText(getString(
                R.string.pending_expression_format,
                formatNumber(storedValue),
                operator
        ));
        startNewInput = true;
    }

    private void calculateResult() {
        if (pendingOperator == null) {
            return;
        }

        double rightValue = parseCurrentInput();
        double result = performCalculation(storedValue, pendingOperator, rightValue);
        expressionText.setText(getString(
                R.string.completed_expression_format,
                formatNumber(storedValue),
                pendingOperator,
                formatNumber(rightValue)
        ));
        currentInput = formatNumber(result);
        pendingOperator = null;
        startNewInput = true;
        updateDisplay();
    }

    private double performCalculation(double left, String operator, double right) {
        try {
            return calculator.calculate(left, operator, right);
        } catch (IllegalArgumentException exception) {
            clearCalculator();
            return 0;
        }
    }

    private void toggleSign() {
        if ("0".equals(currentInput)) {
            return;
        }
        currentInput = currentInput.startsWith("-")
                ? currentInput.substring(1)
                : "-" + currentInput;
        startNewInput = false;
        updateDisplay();
    }

    private void backspace() {
        if (startNewInput) {
            return;
        }
        if (currentInput.length() <= 1
                || (currentInput.startsWith("-") && currentInput.length() == 2)) {
            currentInput = "0";
        } else {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
        }
        updateDisplay();
    }

    private void clearCalculator() {
        currentInput = "0";
        pendingOperator = null;
        storedValue = 0;
        startNewInput = true;
        expressionText.setText(R.string.expression_initial);
        updateDisplay();
    }

    private double parseCurrentInput() {
        return Double.parseDouble(currentInput);
    }

    private void updateDisplay() {
        displayText.setText(currentInput);
    }

    private String formatNumber(double value) {
        if (value >= Long.MIN_VALUE && value <= Long.MAX_VALUE && value == Math.rint(value)) {
            return Long.toString((long) value);
        }
        return Double.toString(value);
    }
}
