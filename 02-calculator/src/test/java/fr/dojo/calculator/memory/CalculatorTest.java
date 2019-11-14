package fr.dojo.calculator.memory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    public void memory() {
        assertEquals(0, this.calculator.getMemory());

        this.calculator.add(2, 3);
        assertEquals(5, this.calculator.getMemory());

        this.calculator.substract(10, 1);
        assertEquals(9, this.calculator.getMemory());

        this.calculator.multiply(3, 2);
        assertEquals(6, this.calculator.getMemory());

        this.calculator.divide(10, 2);
        assertEquals(5, this.calculator.getMemory());
    }

    @Test
    public void cleanMemory() {
        this.calculator.add(10, 2);

        assertEquals(this.calculator.getMemory(), 12);

        this.calculator.cleanMemory();

        assertEquals(this.calculator.getMemory(), 0);

    }

}