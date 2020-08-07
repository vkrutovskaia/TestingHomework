package Test2.TestSuite;
import Test2.Calculator;
import Test2.CalculatorNegativeTest;
import Test2.CalculatorPositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*Negative test scenario for calculation class*/
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorNegativeTest.class,})
public class NegativeCalcTestSuite {

}
