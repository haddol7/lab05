package com.haddol7.lab05calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private final RpnCalculator calculator = new RpnCalculator();

    private EditText expressionInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressionInput = findViewById(R.id.expression_input);
        resultText = findViewById(R.id.result_text);
        Button calculateButton = findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(view -> calculateExpression());
    }

    private void calculateExpression() {
        hideKeyboard();
        try {
            double result = calculator.evaluate(expressionInput.getText().toString());
            resultText.setText(getString(R.string.result_format, formatNumber(result)));
        } catch (IllegalArgumentException exception) {
            resultText.setText(getString(R.string.error_format, exception.getMessage()));
        }
    }

    private String formatNumber(double value) {
        if (value >= Long.MIN_VALUE && value <= Long.MAX_VALUE && value == Math.rint(value)) {
            return Long.toString((long) value);
        }
        return Double.toString(value);
    }

    private void hideKeyboard() {
        InputMethodManager keyboard =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (keyboard != null && getCurrentFocus() != null) {
            keyboard.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}

