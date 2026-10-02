package com.haddol7.lab05calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class RpnCalculatorTest {
    private RpnCalculator calculator;

    @Before
    public void setUp() {
        calculator = new RpnCalculator();
    }

    @Test
    public void addsTwoNumbers() {
        assertEquals(110.0, calculator.evaluate("100 10 +"), 0.0);
    }

    @Test
    public void addsNegativeNumber() {
        assertEquals(90.0, calculator.evaluate("100 -10 +"), 0.0);
    }

    @Test
    public void subtractsTwoNumbers() {
        assertEquals(90.0, calculator.evaluate("100 10 -"), 0.0);
    }

    @Test
    public void subtractsNegativeNumber() {
        assertEquals(110.0, calculator.evaluate("100 -10 -"), 0.0);
    }

    @Test
    public void dividesTwoNumbers() {
        assertEquals(10.0, calculator.evaluate("100 10 /"), 0.0);
    }

    @Test
    public void divisionByZeroReturnsZero() {
        assertEquals(0.0, calculator.evaluate("100 0 /"), 0.0);
    }

    @Test
    public void multipliesTwoNumbers() {
        assertEquals(1000.0, calculator.evaluate("100 10 *"), 0.0);
    }

    @Test
    public void evaluatesMultipleOperationsUsingStackOrder() {
        assertEquals(14.0, calculator.evaluate("5 1 2 + 4 * + 3 -"), 0.0);
    }

    @Test
    public void rejectsInsufficientOperands() {
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluate("10 +"));
    }

    @Test
    public void rejectsMalformedExpression() {
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluate("10 abc +"));
    }
}
