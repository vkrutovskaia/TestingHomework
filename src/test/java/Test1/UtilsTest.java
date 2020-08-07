package Test1;

import Test1.Utils;
import com.sun.istack.internal.NotNull;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Random;

class UtilsTest extends Utils {

    Utils utils = new Utils();

    @Test
    public void testConcatenateAllChecks() {
        String actual = utils.concatenateWords("","");
        Assert.assertEquals(actual.replaceAll("[^\\x00-\\xFF]", "").trim(),actual);
        Assert.assertNotNull(actual);
        Assert.assertFalse(actual.isEmpty());
    }

    @Test /*if one of Strings in Utils is null - test passed*/
    public void testConcatenateWordsIsNotNull()   {
        Assert.assertThrows(NullPointerException.class, ()->concatenateWords(null,null));
        Assert.assertThrows(NullPointerException.class, ()->concatenateWords(null,""));
        Assert.assertThrows(NullPointerException.class, ()-> concatenateWords("",null));

    }
    @Test
    public void testConcatenateWordsHasNotEmptyString(){
        String actual = concatenateWords("","");
        String expected = "";
        Assert.assertNotEquals(expected,actual);
    }
    @Test
    public void testConcatenateWordsNonLatin() {
        String actual = concatenateWords("","");
        String expected = concatenateWords("","").replaceAll("[^\\x00-\\xFF]", "").trim();
        Assert.assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public  void testComputeFactorial() {
        int actual = computeFactorial();
        int expected = 24;
        Assert.assertEquals(expected, actual);

    }
    @Test
    @Timeout(300)
    public void testFactorialWithTimeout() throws InterruptedException{
        int result = 1;
        int factorial = new Random().nextInt();
        int actual = utils.factorialWithTimeout(result, factorial);
        int expected = result;
        Assert.assertEquals(expected, actual);
    }

}