package Test2;

import Test2.TestSuite.PositiveCalcTestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Main {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(PositiveCalcTestSuite.class);
        System.out.println(result.getRunCount());
    }
}
