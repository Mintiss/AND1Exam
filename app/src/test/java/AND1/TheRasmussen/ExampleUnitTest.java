package AND1.TheRasmussen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import AND1.TheRasmussen.ui.lecture_ten.Calculator;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void addTwoNumbers() {
        int result = calculator.addNumbers(10, 1);
        assertEquals(11, result);
    }

    @Test
    public void subtractTwoNumbers() {
        int result = calculator.subtractNumbers(10, 5);
        assertEquals(5, result);
    }

    @Test
    public void multiplyTwoNumbers() {
        int result = calculator.multiplyNumbers(10, 5);
        assertEquals(50, result);
    }

    @Test
    public void devideTwoNumbers() {
        int result = calculator.devideNumbers(10, 5);
        assertEquals(2, result);
    }

    @Test
    public void moduloTest() {
        int result = calculator.modulo(10, 5);
        assertEquals(0, result);
    }

    @Test
    public void bigCalculation() {
        int result = calculator.addNumbers(calculator.modulo(10,6), calculator.multiplyNumbers(calculator.subtractNumbers(20, 10),2));
        assertEquals(24, result);
    }
}
