
/*Class for testing in TestingHomework #1*/

import java.util.Random;

public class Utils {
    public String concatenateWords(String s, String t) {
        s = "русский" ;
        t = "";
        return s.concat(t);
    }

    public int computeFactorial() {
        int factorial = 4;
        int result = 1;
        for (int i = 1; i <= factorial; i++)
            result = result * i;
        return result;
    }
}
