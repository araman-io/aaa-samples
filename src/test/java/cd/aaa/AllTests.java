package cd.aaa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cd.aaa.bowling.BowlingGameTestSuite;
import cd.aaa.classifier.ClassifierTest;
import cd.aaa.number.NumberTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ ClassifierTest.class, NumberTestSuite.class, BowlingGameTestSuite.class})
public class AllTests {

}
