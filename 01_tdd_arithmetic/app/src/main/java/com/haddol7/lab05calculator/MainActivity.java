package com.haddol7.lab05calculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
    private final CalculatorEngine calculator = new CalculatorEngine();

    private EditText leftInput;
    private EditText rightInput;
    private Spinner operatorSpinner;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftInput = findViewById(R.id.left_input);
        rightInput = findViewById(R.id.right_input);
        operatorSpinner = findViewById(R.id.operator_spinner);
        ArrayAdapter<CharSequence> operatorAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.operators,
                R.layout.operator_spinner_item
        );
        operatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operatorSpinner.setAdapter(operatorAdapter);
        resultText = findViewById(R.id.result_text);
        Button calculateButton = findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(view -> calculate());
    }

    private void calculate() {
        hideKeyboard();
        try {
            double left = Double.parseDouble(leftInput.getText().toString().trim());
            double right = Double.parseDouble(rightInput.getText().toString().trim());
            String operator = operatorSpinner.getSelectedItem().toString();
            double result = calculator.calculate(left, operator, right);
            resultText.setText(getString(R.string.result_format, formatNumber(result)));
        } catch (NumberFormatException exception) {
            resultText.setText(R.string.number_input_error);
        } catch (IllegalArgumentException exception) {
            resultText.setText(R.string.operator_error);
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

