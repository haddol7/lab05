package com.haddol7.lab05calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class CalculatorEngineTest {
    private CalculatorEngine engine;

    @Before
    public void setUp() {
        engine = new CalculatorEngine();
    }

    @Test
    public void addsTwoPositiveNumbers() {
        assertEquals(110.0, engine.add(100, 10), 0.0);
    }

    @Test
    public void addsNegativeNumber() {
        assertEquals(90.0, engine.add(100, -10), 0.0);
    }

    @Test
    public void subtractsPositiveNumber() {
        assertEquals(90.0, engine.subtract(100, 10), 0.0);
    }

    @Test
    public void subtractsNegativeNumber() {
        assertEquals(110.0, engine.subtract(100, -10), 0.0);
    }

    @Test
    public void dividesTwoNumbers() {
        assertEquals(10.0, engine.divide(100, 10), 0.0);
    }

    @Test
    public void divisionByZeroReturnsZero() {
        assertEquals(0.0, engine.divide(100, 0), 0.0);
    }

    @Test
    public void multipliesByOne() {
        assertEquals(100.0, engine.multiply(100, 1), 0.0);
    }

    @Test
    public void multipliesTwoNumbers() {
        assertEquals(1000.0, engine.multiply(100, 10), 0.0);
    }

    @Test
    public void dispatchesOperatorToArithmeticMethod() {
        assertEquals(110.0, engine.calculate(100, "+", 10), 0.0);
    }

    @Test
    public void rejectsUnsupportedOperator() {
        assertThrows(
                IllegalArgumentException.class,
                () -> engine.calculate(100, "%", 10));
    }
}

