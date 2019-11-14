package fr.dojo.calculator.exception;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

    private Calculator calculator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test(expected = CalculatorException.class)
    public void divideByZeroWithoutRule() throws CalculatorException {
        this.calculator.divide(15, 0);
    }

    @Test
    public void divideByZeroWithRule() throws CalculatorException {
        this.expectedException.expect(CalculatorException.class);
        this.expectedException.expectMessage("This calculator cannot / by zero");

        this.calculator.divide(15, 0);
    }

}