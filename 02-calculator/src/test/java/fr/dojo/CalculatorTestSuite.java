package fr.dojo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        fr.dojo.calculator.basic.CalculatorTest.class,
        fr.dojo.calculator.exception.CalculatorTest.class
})
public class CalculatorTestSuite {
}
