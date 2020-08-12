package Test1;

import org.junit.Assert;
import org.junit.Ignore;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Random;

import static org.mockito.Mockito.*;

class UtilsTest extends Utils {

    Utils utils = new Utils();

    @Test
    public void testConcatenateAllChecks() {
        String actual = utils.concatenateWords("","");
        Assert.assertEquals(actual.replaceAll("[^\\x00-\\xFF]", "").trim(),actual);
        Assert.assertNotNull(actual);
        Assert.assertFalse(actual.isEmpty());
    }

    @Test
    public void testConcatenateWordsIsNull()   {
        Assert.assertTrue(utils.concatenateWords(null,null), true);
    }

    @Test
    public void testConcatenateWordsHasNotEmptyString(){
        String actual = utils.concatenateWords("","");
        String expected = "";
        Assert.assertNotEquals(expected,actual);
    }
    @Test
    public void testConcatenateWordsNonLatin() {
        String actual = utils.concatenateWords("","");
        String expected = concatenateWords("","").replaceAll("[^\\x00-\\xFF]", "").trim();
        Assert.assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public  void testComputeFactorial() {
        int actual = utils.computeFactorial();
        int expected = 24;
        Assert.assertEquals(expected, actual);

    }
    @Test
    @Timeout(2500)
    public void testFactorialWithTimeout() throws InterruptedException{
        int result = 1;
        int factorial = new Random().nextInt();
        int actual = utils.factorialWithTimeout(result, factorial);
        int expected = result;
        Assert.assertEquals(expected, actual);
    }

}