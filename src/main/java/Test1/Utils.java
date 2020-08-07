package Test1;
/*Class for testing in TestingHomework #1*/

import java.util.Random;

public class Utils {
    public String concatenateWords(String s, String t) {
        s = "";
        t = "null";
        return s.concat(t);
    }

    public int computeFactorial() {
        int factorial = 4;
        int result = 1;
        for (int i = 1; i <= factorial; i++)
            result = result * i;
        return result;
    }

    public int factorialWithTimeout(int result, int factorial) throws InterruptedException {
        result = 1;
        factorial = new Random().nextInt();
        for (int i = 1; i <= factorial; i++)
            result = result * i;
        Thread.sleep(300);
        return result;
    }
}
