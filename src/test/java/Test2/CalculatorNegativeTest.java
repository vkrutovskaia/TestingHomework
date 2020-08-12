package Test2;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class CalculatorNegativeTest {
    public CalculatorNegativeTest() {
    }
    Calculator calculator = new Calculator();
    Scanner scanner = new Scanner(System.in);

    @Test(expected = NullPointerException.class)
    public void testGetFailInt() throws NullPointerException {
        int num = isNull();
        assertThat(num, nullValue());
    }


    @Test/*both failed*/
    public void getFailOperation() {
        Random r = new Random();
        String chars = "^&:?-/*#$%";
        char operation = chars.charAt(r.nextInt(chars.length()));
        assertNotEquals("Enter correct operation, like: + - * /",'+', operation);
    }


    @Test /*always failed, incorrect expected values*/
    public void calcFail() {
        assertNotEquals("incorrect result in calc()",22,calculator.calc(1,1,'+'));
        assertNotEquals("incorrect result in calc()",2,calculator.calc(2,0,'*'));
        assertNotEquals("incorrect result in calc()",0,calculator.calc(2,0,'-'));
        assertNotEquals("incorrect result in calc()",7,calculator.calc(14,1,'/'));
    }
    @Test /*always passed*/
    public void testFailDivision(){
        assertThrows("Error. Division by zero.",ArithmeticException.class, ()-> calculator.calc(-7,0,'/'));
        assertThrows("Error. Division by zero.",ArithmeticException.class, ()-> calculator.calc(7,0,'/'));
    }

}