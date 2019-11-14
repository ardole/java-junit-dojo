package fr.dojo.calculator.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void add() {
        assertEquals(6, this.calculator.add(2,4));
        assertEquals(3, this.calculator.add(0,3));
        assertEquals(-1, this.calculator.add(4,-5));
        assertEquals(-1, this.calculator.add(-5,4));
        assertEquals(28, this.calculator.add(30,-2));
        assertEquals(28, this.calculator.add(-2,30));
    }

    @Test
    public void substract() {
        assertEquals(6, this.calculator.substract(8,2));
        assertEquals(3, this.calculator.substract(5,2));
        assertEquals(-1, this.calculator.substract(5,6));
        assertEquals(1, this.calculator.substract(6,5));
        assertEquals(18, this.calculator.substract(15,-3));
        assertEquals(-18, this.calculator.substract(-3,15));
    }

    @Test
    public void multiply() {
        assertEquals(15, this.calculator.multiply(3,5));
        assertEquals(15, this.calculator.multiply(5,3));
        assertEquals(3, this.calculator.multiply(1,3));
        assertEquals(0, this.calculator.multiply(15,0));
        assertEquals(-20, this.calculator.multiply(2,-10));
    }

    @Test
    public void divide() {
        assertEquals(3, this.calculator.divide(12,4));
        assertEquals(1, this.calculator.divide(5,3));
        assertEquals(0, this.calculator.divide(1,3));
        assertEquals(-4, this.calculator.divide(40,-10));
        assertEquals(20, this.calculator.divide(100,5));
    }

}