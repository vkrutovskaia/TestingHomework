package Test2;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.hamcrest.Description;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.internal.matchers.NotNull;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Random;
import java.util.Scanner;

public class CalculatorNegativeTest {
    public CalculatorNegativeTest() {
    }
    Calculator calculator = new Calculator();
    Scanner scanner = new Scanner(System.in);

    @Test /*exception if value is null*/
    public void testGetFailInt() throws Exception {
        int num = isNull();
        assertThat(num, nullValue());
    }


    @Test/*both failed*/
    public void getFailOperation() {
        Random r = new Random();
        String chars = "^&:?-/*#$%";
        char operation = chars.charAt(r.nextInt(chars.length()));
        assertEquals("Enter correct operation, like: + - * /",'+', operation);
    }


    @Test /*always failed, incorrect expected values*/
    public void calcFail() {
        assertEquals("incorrect result in calc()",22,calculator.calc(1,1,'+'));
        assertEquals("incorrect result in calc()",2,calculator.calc(2,0,'*'));
        assertEquals("incorrect result in calc()",0,calculator.calc(2,0,'-'));
        assertEquals("incorrect result in calc()",7,calculator.calc(14,1,'/'));
    }
    @Test /*always passed*/
    public void testFailDivision(){
        assertThrows("Error. Division by zero.",ArithmeticException.class, ()-> calculator.calc(-7,0,'/'));
        assertThrows("Error. Division by zero.",ArithmeticException.class, ()-> calculator.calc(7,0,'/'));
    }

}