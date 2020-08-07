package Test2;

import Test2.TestSuite.PositiveCalcTestSuite;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Suite;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.internal.matchers.Matches;
import org.mockito.internal.matchers.NotNull;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;

@Suite.SuiteClasses({PositiveCalcTestSuite.class})
public class CalculatorPositiveTest {

    public CalculatorPositiveTest() {
    }

    Calculator calculator = new Calculator();
    Scanner scanner = new Scanner(System.in);

    @Test
    public void testGetInt() {
        int num = new Random().nextInt();
        assertThat(num, notNullValue());
    }
    @Test /*imitation of input by random generation chars*/
    public void testGetOperation() {
        Random r = new Random();
        String chars = "/*+-";
        char operation = chars.charAt(r.nextInt(chars.length()));
        assertEquals('+', operation);
        assertThat(operation, is('+'));
        assertThat(operation, anything());

    }

    @Test
    public void testCalc() {
      assertEquals(4, calculator.calc(2,2,'+'));
      assertEquals(2,calculator.calc(2,1,'*'));
      assertEquals(5,calculator.calc(7,2,'-'));
      assertEquals(7,calculator.calc(14,2,'/'));
    }
    @Test
    public void testAddition() {
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(0,0,'+'));
        assertEquals("incorrect numbers in calc()", 1,calculator.calc(0,1,'+'));
        assertEquals("incorrect numbers in calc()", -3,calculator.calc(0,-3,'+'));
        assertEquals("incorrect numbers in calc()", 3,calculator.calc(1,2,'+'));
        assertEquals("incorrect numbers in calc()", 9,calculator.calc(-3,12,'+'));
        assertEquals("incorrect numbers in calc()", -4,calculator.calc(-2,-2,'+'));
    }
    @Test
    public void testSubsctraction() {
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(0,0,'-'));
        assertEquals("incorrect numbers in calc()", -1,calculator.calc(0,1,'-'));
        assertEquals("incorrect numbers in calc()", 3,calculator.calc(0,-3,'-'));
        assertEquals("incorrect numbers in calc()", -9,calculator.calc(-9,0,'-'));
        assertEquals("incorrect numbers in calc()", 9,calculator.calc(9,0,'-'));
        assertEquals("incorrect numbers in calc()", -1,calculator.calc(1,2,'-'));
        assertEquals("incorrect numbers in calc()", -15,calculator.calc(-3,12,'-'));
        assertEquals("incorrect numbers in calc()", 2,calculator.calc(-2,-4,'-'));
    }
    @Test
    public void testMultiplication(){
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(0,0,'*'));
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(0,1,'*'));
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(0,-3,'*'));
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(-9,0,'*'));
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(9,0,'*'));
        assertEquals("incorrect numbers in calc()", 4,calculator.calc(2,2,'*'));
        assertEquals("incorrect numbers in calc()", -36,calculator.calc(-3,12,'*'));
        assertEquals("incorrect numbers in calc()", 8,calculator.calc(-2,-4,'*'));
    }
    @Test
    public void testDivision(){
        assertThrows("Error. Division by zero.",ArithmeticException.class, ()-> calculator.calc(-7,0,'/'));
        assertThrows("Error. Division by zero.",ArithmeticException.class, ()-> calculator.calc(7,0,'/'));
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(0,1,'/'));
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(0,-3,'/'));
        assertEquals("incorrect numbers in calc()", 1,calculator.calc(9,9,'/'));
        assertEquals("incorrect numbers in calc()", -1,calculator.calc(12,-12,'/'));
        assertEquals("incorrect numbers in calc()", 0,calculator.calc(-2,-4,'/'));
    }
}