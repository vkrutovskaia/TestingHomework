package Test2;

import Test2.TestSuite.PositiveCalcTestSuite;
import org.junit.Test;
import org.junit.runners.Suite;

import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@Suite.SuiteClasses({PositiveCalcTestSuite.class})
public class CalculatorPositiveTest {

    public CalculatorPositiveTest() {
    }

    Calculator calculator = new Calculator();
    Scanner scanner = new Scanner(System.in);

    @Test(timeout = 1000)
    public void testGetInt() {
        Calculator calculator = mock(Calculator.class);
        calculator.getInt();
        int num = new Random().nextInt();
        when(calculator.getInt()).thenReturn(num);
        verify(calculator).getInt();
    }

    @Test(timeout = 1000)
    public void testGetOperation() {
        Calculator calculator = mock(Calculator.class);
        calculator.getOperation();
        char operation = calculator.getOperation();
        when(calculator.getOperation()).thenReturn('+', '-', '*', '/');
        verify(calculator, atLeastOnce()).getOperation();
    }

    @Test
    public void testCalc() {
        assertEquals(4, calculator.calc(2, 2, '+'));
        assertEquals(2, calculator.calc(2, 1, '*'));
        assertEquals(5, calculator.calc(7, 2, '-'));
        assertEquals(7, calculator.calc(14, 2, '/'));
    }

    @Test
    public void testAddition() {
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(0, 0, '+'));
        assertEquals("incorrect numbers in calc()", 1, calculator.calc(0, 1, '+'));
        assertEquals("incorrect numbers in calc()", -3, calculator.calc(0, -3, '+'));
        assertEquals("incorrect numbers in calc()", 3, calculator.calc(1, 2, '+'));
        assertEquals("incorrect numbers in calc()", 9, calculator.calc(-3, 12, '+'));
        assertEquals("incorrect numbers in calc()", -4, calculator.calc(-2, -2, '+'));
    }

    @Test
    public void testSubsctraction() {
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(0, 0, '-'));
        assertEquals("incorrect numbers in calc()", -1, calculator.calc(0, 1, '-'));
        assertEquals("incorrect numbers in calc()", 3, calculator.calc(0, -3, '-'));
        assertEquals("incorrect numbers in calc()", -9, calculator.calc(-9, 0, '-'));
        assertEquals("incorrect numbers in calc()", 9, calculator.calc(9, 0, '-'));
        assertEquals("incorrect numbers in calc()", -1, calculator.calc(1, 2, '-'));
        assertEquals("incorrect numbers in calc()", -15, calculator.calc(-3, 12, '-'));
        assertEquals("incorrect numbers in calc()", 2, calculator.calc(-2, -4, '-'));
    }

    @Test
    public void testMultiplication() {
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(0, 0, '*'));
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(0, 1, '*'));
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(0, -3, '*'));
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(-9, 0, '*'));
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(9, 0, '*'));
        assertEquals("incorrect numbers in calc()", 4, calculator.calc(2, 2, '*'));
        assertEquals("incorrect numbers in calc()", -36, calculator.calc(-3, 12, '*'));
        assertEquals("incorrect numbers in calc()", 8, calculator.calc(-2, -4, '*'));
    }

    @Test
    public void testDivision() {
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(0, 1, '/'));
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(0, -3, '/'));
        assertEquals("incorrect numbers in calc()", 1, calculator.calc(9, 9, '/'));
        assertEquals("incorrect numbers in calc()", -1, calculator.calc(12, -12, '/'));
        assertEquals("incorrect numbers in calc()", 0, calculator.calc(-2, -4, '/'));
    }
}