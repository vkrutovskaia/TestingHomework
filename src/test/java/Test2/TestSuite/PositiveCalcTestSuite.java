package Test2.TestSuite;

import Test2.CalculatorPositiveTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*Positive test scenario for calculation class*/
@RunWith(value=Suite.class)
@Suite.SuiteClasses(value={CalculatorPositiveTest.class})
public class PositiveCalcTestSuite {

}
