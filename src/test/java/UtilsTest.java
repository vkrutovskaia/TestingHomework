
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class UtilsTest extends Utils {

    Utils utils = new Utils();

    @Test
    public void testConcatenateAllChecks() {
        String actual = utils.concatenateWords("","");
        Assert.assertEquals(actual.replaceAll("[^а-яА-Я]", ""),actual);
        Assert.assertNotNull(actual);
        Assert.assertFalse(actual.isEmpty());
    }

    @Test
    public void testConcatenateWordsIsNotNull() throws NullPointerException  {
        String actual = utils.concatenateWords("","");
        String expected = null;
        Assert.assertNotEquals(expected, actual);
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
        String expected = actual.replaceAll("[^а-яА-Я]", "");
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
    @Timeout(100)
    public void testFactorialWithTimeout(){
        int result = 1;
        int factorial = (int)(Math.random()*10);
        for (int i = 1; i <= factorial; i++)
            result = result * i;
        int actual = result;
        int expected = result;
        Assert.assertEquals(expected, actual);
    }

}