package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class AllTests to run all tests as a test suite.
 *
 * @author Nick Bogachev
 */
@RunWith(Suite.class)
@SuiteClasses({
    EntryTest.class,
    StackTest.class,
    SymbolTest.class,
    NumStackTest.class,
    OpStackTest.class,
    StrStackTest.class,
    RevPolishTest.class,
    StandardCalcTest.class,
    CalcModelTest.class})
public class AllTests {

}
