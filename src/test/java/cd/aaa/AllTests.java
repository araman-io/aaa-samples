package cd.aaa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cd.aaa.bowling.BowlingGameTestSuite;
import cd.aaa.classifier.ClassifierTest;
import cd.aaa.number.NumberTestSuite;
import cd.aaa.roomsearch.RoomSearchFacadeTest;
import cd.aaa.roomsearch.RoomSearchIntegrationTest;

@RunWith(Suite.class)
@SuiteClasses({ ClassifierTest.class, NumberTestSuite.class, BowlingGameTestSuite.class, RoomSearchFacadeTest.class,
		RoomSearchIntegrationTest.class, RunCukesTest.class })
public class AllTests {

}
