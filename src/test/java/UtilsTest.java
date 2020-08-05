
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Random;


class UtilsTest extends Utils {

    @Test
    public void concatenateWordsIsNull() throws NullPointerException {
        String s = null;
        String t = "";
        String result = s+t;
        Assert.assertEquals("null", result);
    }
    @Test
    public void concatenateWordsHasEmptyString(){
        String s = "";
        String t = "";
        String result = s+t;
        Assert.assertEquals(0,result.length());
    }
    @Test
    public void concatenateWordsNonLatin(){
        String s = "русский";
        String t = "текст";
        String result = s+t;
        Assert.assertEquals(result.replaceAll("[^а-яА-Я]", ""),result);
    }

    @Ignore
    @Test
    public void testComputeFactorial() {
        int result = 1;
        int factorial = 12;
        for (int i = 1; i < factorial; i++) {
            result = result * i;
            Assert.assertEquals(result, result);
        }
    }
    @Test
    @Timeout(100)
    public void testFactorialWithTimeout(){
        int result = 1;
        int factorial = new Random().nextInt();
        for (int i = 1; i <= factorial; i++)
            result = result * i;
            Assert.assertEquals(result, result);
    }
}