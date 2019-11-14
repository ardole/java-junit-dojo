package fr.dojo.calculator.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorParameterizedTest {

    @Parameters(name = "{index}: {0} + {1}={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {2, 3, 5}, {10, 10, 20}, {0, 1, 1}
        });
    }

    @Parameter(0)
    public int a;
    @Parameter(1)
    public int b;
    @Parameter(2)
    public int result;

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        assertEquals(this.result, calculator.add(this.a,this.b));
    }
}


